/**
 * 
 */
package br.com.rpires.VendaServiceProfessor.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author rodrigo.pires
 *
 */
@Component
public class RestUtils {
	
	private static final Logger logger = LoggerFactory.getLogger(RestUtils.class);

	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	public <T> ResponseEntity<T> execute(String url, RestRequest request, Class<T> responseType, Object... uriVariables) {
		logCall(request.getMethod(), url, request.getHttpEntity(), uriVariables);
		long start = System.currentTimeMillis();
		try {
			ResponseEntity<T> exchange = restTemplate.exchange(url, request.getMethod(), request.getHttpEntity(), responseType, uriVariables);
			return exchange;
		} catch(Exception e) {
			logError(request.getMethod(), url, e);
			throw e;
		} finally {
			logElapsed(request.getMethod(), url, start);
		}
	}
	
	private void logCall(HttpMethod method, String url, HttpEntity<?> httpEntity, Object[] uriVariables) {
		HttpHeaders headers = null;
		Object body = null;
		if (httpEntity != null) {
			headers = httpEntity.getHeaders();
			body = httpEntity.getBody();
		}
		
		logger.debug("EXECUTANDO ENDPOINT COM {} NA URL: {}, PARAMETERS: {}, HEADERS: {} E BODY: {}", method, url, uriVariables, asJSON(headers), asJSON(body));
	}
	
	private void logError(HttpMethod method, String url, Exception e) {
		logger.error("ERRO NO ENDPOINT COM {} NA URL: {} - {}", method, url, e.getMessage());
	}
	
	private void logElapsed(HttpMethod method, String url, long start) {
		logger.debug("ELAPSED TIME on ENDPOINT WITH {} IN URL: {} - {} ms", method, url, System.currentTimeMillis()-start);
	}
	
	protected String asJSON(Object dto) {
		if (dto == null) {
			return null;
		}
		try {
			return objectMapper.writeValueAsString(dto);
		} catch (JsonProcessingException e) {
			//NÃO FAZER NADA POIS NÃO É UMA REGRA DE NEGÓCIO LEVANTAR EXCEPTION IMPRIMINDO LOG.
			logger.error("ERROR CONVERTING OBJECT TO JSON");
			return null;
		}
	}
}
