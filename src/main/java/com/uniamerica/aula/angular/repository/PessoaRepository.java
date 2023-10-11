package com.uniamerica.aula.angular.repository;

import com.uniamerica.aula.angular.entity.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
}
