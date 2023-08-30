package com.estacionamento.estacionamento.service;


import com.estacionamento.estacionamento.entity.Cliente;
import com.estacionamento.estacionamento.entity.Vaga;
import com.estacionamento.estacionamento.entity.form.VagaForm;
import com.estacionamento.estacionamento.repository.ClienteRepository;
import com.estacionamento.estacionamento.repository.VagaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalTime;
import java.util.List;


@Service
public class VagaService {

    @Autowired
    private VagaRepository vagaRepository;
    @Autowired
    private ClienteRepository clienteRepository;

    /* contador para fazer a contagem de vagas disponíveis.
    Ele indica o número de vagas que estão ocupadas.
     É incrementado quando se cria uma vaga e decrementado quando se atualiza. */
    private int contadorVagas=0;



    public Vaga create(VagaForm vagaForm){
        Vaga vaga = new Vaga();
        Cliente cliente = clienteRepository.findById(vagaForm.getClienteID()).get();

        vaga.setCliente(cliente);
        contadorVagas++;

        return vagaRepository.save(vaga);

    }

    public List<Vaga> getAll(){
        return vagaRepository.findAll();
    }

    /* método update salva o horário de saída,
    faz o cálculo do tempo de permanencia do cliente
    e calcula o valor a ser pago

    Duration calcula a diferença entre os horários

    Um carro entra às 10:20 e sai às 11:25, então ele já está usando a 2ª hora
    de permanencia. A diferença entre as variáveis de hora será igual a 1.
    Por isso, é necessário levar em conta a diferença dos minutos. */
    public Vaga update(long id){
        double valor;
        Vaga vaga = vagaRepository.findById(id).get();
        vaga.setSaida(LocalTime.now());

        Duration duration = Duration.between(vaga.getEntrada(), vaga.getSaida());
        long horas = duration.toHours();
        long minutos = duration.toMinutes();

        //condições para verificar se a contagem  de minutos completou 1 hora
        if(minutos > 0){ //ultrapassou os 60 minutos
            horas = horas+1;
            valor = vaga.getValorHora()*horas;
            vaga.setValorTotal(valor);
        }else if(minutos< 0){ //não se passaram 60 minutos
            horas = horas-1;
            valor = vaga.getValorHora()*horas;
            vaga.setValorTotal(valor);
        }else {
            valor = vaga.getValorHora() * horas;
            vaga.setValorTotal(valor);
        }

        contadorVagas--;

        return vagaRepository.save(vaga);
    }

    public Vaga get(long id){
        return vagaRepository.findById(id).get();
    }

    //Faz o cálculo do número de vagas disponíveis utilizando o contador.
    public String vagasDisponiveis(){
        String mensagem;
        int totalVagas = 10;
        int disponiveis = totalVagas -contadorVagas;

        if(disponiveis == 0) {
            mensagem = "Nenhuma vaga livre!";
        }
        mensagem = "Temos "+disponiveis+" vagas livres!";

        return mensagem;
    }




}
