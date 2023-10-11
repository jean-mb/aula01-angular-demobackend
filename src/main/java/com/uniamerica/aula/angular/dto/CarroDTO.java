package com.uniamerica.aula.angular.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CarroDTO {
    private Long id;
    @NotNull(message = "Modelo deve ser informado!")
    @Length(min = 2, max = 10, message = "Modelo deve conter entre 2 e 10 caracteres!")
    private String modelo;
    @NotNull(message = "Ano deve ser informado!")
    private Integer ano;
}

