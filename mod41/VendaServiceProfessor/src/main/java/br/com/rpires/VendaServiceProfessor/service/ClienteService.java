/**
 * 
 */
package br.com.rpires.VendaServiceProfessor.service;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 * @author rodrigo.pires
 *
 */
@Service
public class ClienteService {
	
	@Value("${application.clienteService.endpointConsultarCliente}")
	private String urlEndpointConsultarCliente;
	
	private RestUtils restUtils;
	
	@Autowired
	public ClienteService(RestUtils restUtils) {
		this.restUtils = restUtils;
	}

	public Boolean isClienteCadastrado(String clienteId) {
		RestRequest restRequest = new RestRequest(HttpMethod.GET, null);
		restRequest.setContentType(MediaType.APPLICATION_JSON);
		restRequest.setAcceptable(Collections.singletonList(MediaType.APPLICATION_JSON));
		String urlComParam = urlEndpointConsultarCliente.replace("{id}", clienteId);
		ResponseEntity<Boolean> response = restUtils.execute(urlComParam, restRequest, Boolean.class);
		return response.getBody();
	}
}
