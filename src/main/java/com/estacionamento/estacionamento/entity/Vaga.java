package com.estacionamento.estacionamento.entity;

import lombok.Data;


import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "tb_vaga")
@Data
public class Vaga {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @Column(name="valor_hora")
    private double valorHora = 2;

    @Column(name="valor_total")
    private double valorTotal;

    @Column(name="data")
    private LocalDate data = LocalDate.now();


    @Column(name="hora_entrada")
    private LocalTime entrada = LocalTime.now();


    @Column(name="hora_saida")
    private LocalTime saida;

}
