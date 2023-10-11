package com.uniamerica.aula.angular.dto;

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
public class PessoaDTO {
    private Long id;
    @NotNull(message = "Nome deve ser informado!")
    @Length(min=2, max=10,message = "Nome deve ter entre 2 e 10 caracteres!")
    private String nome;
    @NotNull(message = "Idade deve ser informada!")
    private Integer idade;
}
