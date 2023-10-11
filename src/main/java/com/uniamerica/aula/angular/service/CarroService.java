package com.uniamerica.aula.angular.service;

import com.uniamerica.aula.angular.dto.CarroDTO;
import com.uniamerica.aula.angular.dto.PessoaDTO;
import com.uniamerica.aula.angular.entity.Carro;
import com.uniamerica.aula.angular.entity.Pessoa;
import com.uniamerica.aula.angular.repository.CarroRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.List;

@Service
public class CarroService {
    @Autowired
    CarroRepository repository;

    private final ModelMapper mapper = new ModelMapper();

    public CarroDTO toCarroDTO(Carro carro){
        return mapper.map(carro, CarroDTO.class);
    }
    public Carro toCarro(CarroDTO carroDTO){
        return mapper.map(carroDTO, Carro.class);
    }

    public List<CarroDTO> getAll(){
        return repository.findAll().stream().map(this::toCarroDTO).toList();
    }
    public CarroDTO getById(Long id){
        Carro carroById = repository.findById(id).orElse(null);
        Assert.notNull(carroById, String.format("Carro com ID %s não existe!", id));
        return toCarroDTO(carroById);
    }
    @Transactional
    public CarroDTO post(CarroDTO carroDTO){
        return toCarroDTO(repository.save(toCarro(carroDTO)));
    }

    @Transactional
    public CarroDTO put(Long id, CarroDTO carroDTO){
        Assert.notNull(carroDTO.getId(), "ID do Carro não informado");
        Assert.notNull(id, "ID da Carro não informado na requisição");
        Assert.isTrue(carroDTO.getId().equals(id), "ID da Carro não pode ser alterado");
        return toCarroDTO(repository.save(toCarro(carroDTO)));
    }

    @Transactional
    public void delete(Long id){
        getById(id);
        repository.deleteById(id);
    }

}
