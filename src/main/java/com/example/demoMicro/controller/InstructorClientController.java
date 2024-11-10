package com.example.demoMicro.controller;

import com.example.demoMicro.model.Instructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/instructorsClient")
public class InstructorClientController {

    private final String BASE_URL = "http://localhost:9000"; // URL base del proyecto original

    @Autowired
    private RestTemplate restTemplate;

    // Obtener todos los instructores
    @GetMapping("/all")
    public ResponseEntity<List> getAllInstructors() {
        ResponseEntity<List> response = restTemplate.exchange(
                BASE_URL + "/all",
                HttpMethod.GET,
                null,
                List.class
        );
        return response;
    }

    // Obtener un instructor por ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getInstructorById(@PathVariable Integer id) {
        try {
            ResponseEntity<Instructor> response = restTemplate.getForEntity(
                    BASE_URL + "/" + id,
                    Instructor.class
            );
            return response;
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Instructor no encontrado");
        }
    }

    // Crear un instructor
    @PostMapping("/create")
    public ResponseEntity<Instructor> createInstructor(@RequestBody Instructor instructor) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Instructor> request = new HttpEntity<>(instructor, headers);

        return restTemplate.exchange(
                BASE_URL + "/create",
                HttpMethod.POST,
                request,
                Instructor.class
        );
    }

    // Actualizar un instructor por ID
    @PutMapping("/update/{id}")
    public ResponseEntity<Instructor> updateInstructor(@PathVariable Integer id, @RequestBody Instructor instructor) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Instructor> request = new HttpEntity<>(instructor, headers);

        return restTemplate.exchange(
                BASE_URL + "/" + id,
                HttpMethod.PUT,
                request,
                Instructor.class
        );
    }

    // Eliminar un instructor por ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteInstructor(@PathVariable Integer id) {
        try {
            restTemplate.delete(BASE_URL + "/" + id);
            return ResponseEntity.ok("Instructor eliminado con éxito.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Instructor con ID " + id + " no encontrado.");
        }
    }
}
