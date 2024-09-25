package com.curso.cliente.service.impl;

import com.curso.cliente.model.Ejemplar;
import com.curso.cliente.service.EjemplaresService;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

public class EjemplaresServiceImpl implements EjemplaresService {
    private final RestTemplate restTemplate;
    private final RestClient restClient;
    private final String url = "http://localhost:8080/";


    public EjemplaresServiceImpl(RestTemplate restTemplate, RestClient restClient) {
        this.restTemplate = restTemplate;
        this.restClient = restClient;
    }

    @Override
    public List<Ejemplar> nuevoEjemplar(Ejemplar ejemplar) {
        this.restTemplate.postForLocation(this.url + "libro", ejemplar);
        return Arrays.asList(this.restTemplate.getForObject(this.url + "libros", Ejemplar[].class));
    }

    @Override
    public List<Ejemplar> nuevoEjemplarRestClient(Ejemplar ejemplar) {
        this.postEjemplar(this.url + "libro", ejemplar);
        return Arrays.asList(this.getEjemplares(this.url + "libros"));
    }

    private void postEjemplar(String url, Ejemplar ejemplar) {
        this.restClient.post()
                .uri(url)
                .accept(MediaType.APPLICATION_JSON)
                .body(ejemplar)
                .retrieve()
                .toBodilessEntity();
    }

    private Ejemplar[] getEjemplares(String url) {
        return this.restClient.get()
                .uri(url)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .body(Ejemplar[].class);
    }

}
