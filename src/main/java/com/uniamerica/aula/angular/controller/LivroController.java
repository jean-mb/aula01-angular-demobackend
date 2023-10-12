package com.uniamerica.aula.angular.controller;

import com.uniamerica.aula.angular.dto.LivroDTO;
import com.uniamerica.aula.angular.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/livros")
@CrossOrigin(origins = "http://localhost:4200")
public class LivroController {
    @Autowired
    LivroService service;

    @GetMapping("/id/{id}")
    public ResponseEntity<LivroDTO> getById(@PathVariable Long id){
        return ResponseEntity.ok(service.getById(id));
    }
    @GetMapping("/all")
    public ResponseEntity<List<LivroDTO>> getAll(){
        return ResponseEntity.ok(service.getAll());
    }
    @PostMapping("/post")
    public ResponseEntity<LivroDTO> post(@RequestBody @Validated LivroDTO livroDTO){
        return ResponseEntity.ok(service.post(livroDTO));
    }
    @PutMapping("/put/{id}")
    public ResponseEntity<LivroDTO> put(@PathVariable Long id, @RequestBody @Validated LivroDTO livroDTO){
        return ResponseEntity.ok(service.put(id, livroDTO));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable Long id){
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
