package com.example.demoMicro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.ExecutionException;

@RestController
public class helloController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private RestTemplate authRestTemplate;


    @GetMapping("/hello")
    public String saludar() 	{
        return "Holla bienvenido";
    }

    @GetMapping("/callMicroPublic")
    public ResponseEntity<String> callMicroPublic() {
        String response = restTemplate.getForObject("http://localhost:9000/listar_public", String.class);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/callMicroBasic")
    public ResponseEntity<String> callMicroBasic() {
        String response = authRestTemplate.getForObject("http://localhost:9000/listar_admin", String.class);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    /* usando Parametros*/
    /*
    @GetMapping("/callMicroserviceB")
    public ResponseEntity<String> callMicroserviceB(@RequestParam(defaultValue = "MicroserviceB") String name) {
        String response = restTemplate.getForObject("http://localhost:9001/api/v1/microserviceB/hello?name={name}", String.class, name);
        return ResponseEntity.ok(response);
    }
    */

}
