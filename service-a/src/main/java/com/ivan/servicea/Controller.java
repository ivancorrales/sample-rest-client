package com.ivan.servicea;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;

import java.util.List;

@RestController
public class Controller {

    @Autowired
    @Qualifier("service-b")
    private RestClient servicebRestClient;

    @Autowired
    @Qualifier("service-c")
    private RestClient servicecRestClient;

    @PostMapping("/test-b")
    public ResponseEntity<Response> metodoB(@RequestBody Request request){
        System.out.println("Llama a service B");
        Response response =  servicebRestClient
                .post()
                .uri("/test")
                .body(request)
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .retrieve()
                .body(Response.class);

        return ResponseEntity.ok(response);
    }


    @PostMapping("/test-c")
    public ResponseEntity<Response> metodoC(@RequestBody Request request){
        System.out.println("Llama a service C");
        Response response =  servicecRestClient
                .post()
                .uri("/test")
                .body(request)
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .retrieve()
                .body(Response.class);

        return ResponseEntity.ok(response);
    }
}
