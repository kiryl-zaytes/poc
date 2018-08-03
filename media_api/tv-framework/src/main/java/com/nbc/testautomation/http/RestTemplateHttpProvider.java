package com.nbc.testautomation.http;

import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

public class RestTemplateHttpProvider implements HttpProvider {

    protected RestTemplate restTemplate = new RestTemplate();

    public <T> T get(String host, String path, Class<T> returnType) {
        URI uri = UriComponentsBuilder.fromHttpUrl(host).path(path).build().toUri();
        RequestEntity<?> requestEntity = new RequestEntity(HttpMethod.GET, uri);

        return restTemplate.exchange(requestEntity, returnType).getBody();
    }
}
