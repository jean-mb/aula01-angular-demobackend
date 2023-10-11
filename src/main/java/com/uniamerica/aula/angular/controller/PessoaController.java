package com.uniamerica.aula.angular.controller;

import com.uniamerica.aula.angular.dto.PessoaDTO;
import com.uniamerica.aula.angular.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pessoas")
@CrossOrigin(origins = "http://localhost:4200")
public class PessoaController {
    @Autowired
    PessoaService service;

    @GetMapping("/id/{id}")
    public ResponseEntity<PessoaDTO> getById(@PathVariable Long id){
        return ResponseEntity.ok(service.getById(id));
    }
    @GetMapping("/all")
    public ResponseEntity<List<PessoaDTO>> getAll(){
        return ResponseEntity.ok(service.getAll());
    }
    @PostMapping("/post")
    public ResponseEntity<PessoaDTO> post(@RequestBody @Validated PessoaDTO pessoaDTO){
        return ResponseEntity.ok(service.post(pessoaDTO));
    }
    @PutMapping("/put/{id}")
    public ResponseEntity<PessoaDTO> put(@PathVariable Long id, @RequestBody @Validated PessoaDTO pessoaDTO){
        return ResponseEntity.ok(service.put(id, pessoaDTO));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable Long id){
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
