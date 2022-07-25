package com.ynov.controle_front.backend;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@FeignClient(value = "backend")
public interface BackendFeignClient {
    @PostMapping(path = "/Messages", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    MessageDTO ajouterMessage(@RequestHeader(HttpHeaders.AUTHORIZATION) String token, @RequestBody MessageDTO message);

    @GetMapping(path = "/Messages/{id}", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    MessageDTO afficherUnMessage(@RequestHeader(HttpHeaders.AUTHORIZATION) String token, @PathVariable("id") int id);

    @GetMapping(path = "/Messages/", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    MessageDTO listeMessages(@RequestHeader(HttpHeaders.AUTHORIZATION) String token);
}
