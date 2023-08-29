package com.estacionamento.estacionamento.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "tb_cliente")
@Data
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String nome;
    private String placaCarro;

    @OneToMany(mappedBy = "cliente")
    @JsonIgnore
    private List<Vaga> vagas =new ArrayList<>();

}
