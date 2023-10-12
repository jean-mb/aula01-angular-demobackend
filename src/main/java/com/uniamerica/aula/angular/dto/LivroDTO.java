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
public class LivroDTO {
    private Long id;
    @NotNull(message = "Título do livro deve ser informado!")
    @Length(min = 2, max = 20, message = "Título deve conter entre 2 e 20 caracteres!")
    private String titulo;
    @NotNull(message = "Autor do livro deve ser informado!")
    @Length(min = 2, max = 10, message = "Título deve conter entre 2 e 10 caracteres!")
    @Column(nullable = false)
    private String autor;
}
