package com.estacionamento.estacionamento.entity.form;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class ClienteUpdatePlacaForm {

    @NotEmpty(message = "Preencha o campo corretamente.")
    private String placaCarro;
}
