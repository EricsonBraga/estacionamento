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

    public Vaga update(long id){
        double valor;
        Vaga vaga = vagaRepository.findById(id).get();
        vaga.setSaida(LocalTime.now());

        Duration duration = Duration.between(vaga.getEntrada(), vaga.getSaida());
        long horas = duration.toHours();
        long minutos = duration.toMinutes();
        if(minutos > 0){
            horas = horas+1;
            valor = vaga.getValorHora()*horas;
            vaga.setValorTotal(valor);
        }else if(minutos< 0){
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
