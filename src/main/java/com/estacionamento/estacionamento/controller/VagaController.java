package com.estacionamento.estacionamento.controller;

import com.estacionamento.estacionamento.entity.Vaga;
import com.estacionamento.estacionamento.entity.form.VagaForm;
import com.estacionamento.estacionamento.service.ClienteService;
import com.estacionamento.estacionamento.service.VagaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/vagas")
public class VagaController {

    @Autowired
    private VagaService vagaService;

    @Autowired
    private ClienteService clienteService;

    @PostMapping
    public Vaga create(@RequestBody VagaForm vagaForm){
        return vagaService.create(vagaForm);
    }

    @GetMapping
    public List<Vaga> getAll(){
        return vagaService.getAll();
    }

    @PutMapping("/{id}")
    public Vaga update(@PathVariable long id){
        return vagaService.update(id);
    }

    @GetMapping("/{id}")
    public Vaga get(@PathVariable long id){return vagaService.get(id);}

    @GetMapping("/vagasdiponiveis")
    public String vagasDisponiveis(){
        return vagaService.vagasDisponiveis();}

    @GetMapping("/registroClientes")
    public List<Vaga>getVagaClienteId(@RequestParam UUID id){
        return clienteService.getVagasClienteId(id);
    }
}
