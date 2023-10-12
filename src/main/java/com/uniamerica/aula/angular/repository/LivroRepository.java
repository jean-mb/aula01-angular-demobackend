package com.uniamerica.aula.angular.repository;

import com.uniamerica.aula.angular.entity.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<Livro, Long> {
}
