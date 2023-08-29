package com.estacionamento.estacionamento.entity.form;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class ClienteUpdateNomeForm {

    @NotEmpty(message = "Preencha o campo corretamente.")
    private String nome;
}
