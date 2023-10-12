package com.uniamerica.aula.angular.service;

import com.uniamerica.aula.angular.dto.LivroDTO;
import com.uniamerica.aula.angular.entity.Livro;
import com.uniamerica.aula.angular.repository.LivroRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.List;

@Service
public class LivroService {
    @Autowired
    LivroRepository repository;

    private final ModelMapper mapper = new ModelMapper();

    public LivroDTO toLivroDTO(Livro livro){
        return mapper.map(livro, LivroDTO.class);
    }
    public Livro toLivro(LivroDTO livroDTO){
        return mapper.map(livroDTO, Livro.class);
    }

    public LivroDTO getById(Long id){
        Livro livroById = repository.findById(id).orElse(null);
        Assert.notNull(livroById, String.format("Livro com ID %s não existe!", id));
        return toLivroDTO(livroById);
    }

    public List<LivroDTO> getAll(){
        return repository.findAll().stream().map(this::toLivroDTO).toList();
    }

    @Transactional
    public LivroDTO post(LivroDTO livroDTO){
        return toLivroDTO(repository.save(toLivro(livroDTO)));
    }

    @Transactional
    public LivroDTO put(Long id, LivroDTO livroDTO){
        Assert.notNull(livroDTO.getId(), "ID do Livro não informado");
        Assert.notNull(id, "ID do Livro não informado na requisição");
        Assert.isTrue(livroDTO.getId().equals(id), "ID do Livro não pode ser alterado");
        return toLivroDTO(repository.save(toLivro(livroDTO)));
    }

    @Transactional
    public void delete(Long id){
        getById(id);
        repository.deleteById(id);
    }
}
