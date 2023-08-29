package com.estacionamento.estacionamento.entity.form;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.UUID;
@Data
public class VagaForm {

    @NotNull
    private UUID clienteID;
}
