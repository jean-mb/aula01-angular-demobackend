package com.uniamerica.aula.angular.controller;

import com.uniamerica.aula.angular.dto.CarroDTO;
import com.uniamerica.aula.angular.dto.PessoaDTO;
import com.uniamerica.aula.angular.service.CarroService;
import com.uniamerica.aula.angular.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/carros")
@CrossOrigin(origins = "http://localhost:4200")
public class CarroController {
    @Autowired
    CarroService service;

    @GetMapping("/id/{id}")
    public ResponseEntity<CarroDTO> getById(@PathVariable Long id){
        return ResponseEntity.ok(service.getById(id));
    }
    @GetMapping("/all")
    public ResponseEntity<List<CarroDTO>> getAll(){
        return ResponseEntity.ok(service.getAll());
    }
    @PostMapping("/post")
    public ResponseEntity<CarroDTO> post(@RequestBody @Validated CarroDTO carroDTO){
        return ResponseEntity.ok(service.post(carroDTO));
    }
    @PutMapping("/put/{id}")
    public ResponseEntity<CarroDTO> put(@PathVariable Long id, @RequestBody @Validated CarroDTO carroDTO){
        return ResponseEntity.ok(service.put(id, carroDTO));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable Long id){
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
