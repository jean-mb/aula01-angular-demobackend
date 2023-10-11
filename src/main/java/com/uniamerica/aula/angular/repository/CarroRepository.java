package com.uniamerica.aula.angular.repository;

import com.uniamerica.aula.angular.entity.Carro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarroRepository extends JpaRepository<Carro, Long> {
}
