package br.com.rpires.vendas.online.service;

import java.util.List;

import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.lang.Nullable;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

public class RestRequest {

    private HttpHeaders headers;
    private Object bodyObject;
    private MultiValueMap<String, Object> body;
    private HttpMethod method;

    public HttpMethod getMethod() {
        return this.method;
    }

    public enum DispositionType {

        INLINE("inline"), ATTACHMENT("attachment"), FORM_DATA("form-data");

        private String type;

        DispositionType(String type) {
            this.type = type;
        }

        public String getType() {
            return type;
        }
    }


    public RestRequest(HttpMethod method, Object body) {
        this.bodyObject = body;
        this.method = method;
        this.headers = new HttpHeaders();
        this.body = new LinkedMultiValueMap<>();
    }

    public void setContentType(@Nullable MediaType mediaType) {
        this.headers.setContentType(mediaType);
    }

    public void setAcceptable(List<MediaType> acceptableMediaTypes) {
        this.headers.setAccept(acceptableMediaTypes);
    }

    public void setBearerToken(@Nullable String token) {
        this.headers.set(HttpHeaders.AUTHORIZATION, "Bearer " + token);
    }

    public void addHeader(@Nullable String headerName, @Nullable String headerValue) {
        this.headers.set(headerName, headerValue);
    }

    public HttpEntity<?> getHttpEntity() {
        if(this.bodyObject!=null && this.bodyObject instanceof HttpEntity<?>) {
            return (HttpEntity<?>) bodyObject;
        } else if(!this.body.isEmpty()) {
            return new HttpEntity<>(body, getHeaders());
        } else {
            return new HttpEntity<>(bodyObject, getHeaders());
        }
    }

    public void addMultiValueMap(String parameterName, Object value) {
        this.body.add(parameterName, value);
    }

    public void addMultiValueMap(DispositionType dispositionType, String parameterName, Object value) {
        MultiValueMap<String, String> fileMap = new LinkedMultiValueMap<>();
        ContentDisposition contentDisposition = ContentDisposition
                .builder(dispositionType.getType())
                .name(parameterName)
                .build();
        fileMap.add(HttpHeaders.CONTENT_DISPOSITION, contentDisposition.toString());
        HttpEntity<?> fileEntity = new HttpEntity<>(value, fileMap);
        body.add(parameterName, fileEntity);
    }

    public void addImageOrFileMultiValueMap(DispositionType dispositionType, String parameterName, String fileName, Object value) {
        MultiValueMap<String, String> fileMap = new LinkedMultiValueMap<>();
        ContentDisposition contentDisposition = ContentDisposition
                .builder(dispositionType.getType())
                .name(parameterName)
                .filename(fileName)
                .build();
        fileMap.add(HttpHeaders.CONTENT_DISPOSITION, contentDisposition.toString());
        HttpEntity<?> fileEntity = new HttpEntity<>(value, fileMap);
        body.add(parameterName, fileEntity);
    }

    public HttpHeaders getHeaders() {
        return headers;
    }

    public MultiValueMap<String, Object> getBody() {
        return body;
    }


}
