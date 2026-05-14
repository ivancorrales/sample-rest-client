package com.ivan.servicea;

import org.springframework.beans.factory.annotation.Autowired;
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
    private RestClient servicebRestClient;

    @PostMapping("/test")
    public ResponseEntity<Response> metodo(@RequestBody Request request){

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
}
