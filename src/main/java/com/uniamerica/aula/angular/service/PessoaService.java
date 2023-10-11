package com.uniamerica.aula.angular.service;

import com.uniamerica.aula.angular.dto.PessoaDTO;
import com.uniamerica.aula.angular.entity.Pessoa;
import com.uniamerica.aula.angular.repository.PessoaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.List;

@Service
public class PessoaService {
    @Autowired
    PessoaRepository repository;

    private final ModelMapper mapper = new ModelMapper();

    public PessoaDTO toPessoaDTO(Pessoa pessoa){
        return mapper.map(pessoa, PessoaDTO.class);
    }
    public Pessoa toPessoa(PessoaDTO pessoaDTO){
        return mapper.map(pessoaDTO, Pessoa.class);
    }

    public PessoaDTO getById(Long id){
        Pessoa pessoaById = repository.findById(id).orElse(null);
        Assert.notNull(pessoaById, String.format("Pessoa com ID %s não existe!", id));
        return toPessoaDTO(pessoaById);
    }

    public List<PessoaDTO> getAll(){
        return repository.findAll().stream().map(this::toPessoaDTO).toList();
    }

    @Transactional
    public PessoaDTO post(PessoaDTO pessoaDTO){
        return toPessoaDTO(repository.save(toPessoa(pessoaDTO)));
    }

    @Transactional
    public PessoaDTO put(Long id, PessoaDTO pessoaDTO){
        Assert.notNull(pessoaDTO.getId(), "ID da Pessoa não informado");
        Assert.notNull(id, "ID da Pessoa não informado na requisição");
        Assert.isTrue(pessoaDTO.getId().equals(id), "ID da Pessoa não pode ser alterado");
        return toPessoaDTO(repository.save(toPessoa(pessoaDTO)));
    }

    @Transactional
    public void delete(Long id){
        getById(id);
        repository.deleteById(id);
    }
}
