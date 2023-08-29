package com.estacionamento.estacionamento.controller;

import com.estacionamento.estacionamento.entity.Cliente;
import com.estacionamento.estacionamento.entity.Vaga;
import com.estacionamento.estacionamento.entity.form.ClienteForm;
import com.estacionamento.estacionamento.entity.form.ClienteUpdateNomeForm;
import com.estacionamento.estacionamento.entity.form.ClienteUpdatePlacaForm;
import com.estacionamento.estacionamento.service.ClienteService;
import com.estacionamento.estacionamento.service.VagaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private VagaService vagaService;

    @PostMapping
    public Cliente create(@Valid @RequestBody ClienteForm clienteForm){
        return clienteService.create(clienteForm);
    }

    @GetMapping
    public List<Cliente> getAll(){
        return clienteService.getAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id){
        clienteService.delete(id);
    }

    @PutMapping("/{id}")
    public Cliente update(@PathVariable UUID id, @Valid @RequestBody ClienteForm clienteForm){
        return clienteService.update(id, clienteForm);
    }

    @PutMapping("/name/{id}")
    public Cliente updateName(@PathVariable UUID id,
                              @Valid @RequestBody ClienteUpdateNomeForm nomeForm){
        return clienteService.updateName(id, nomeForm);
    }

    @PutMapping("/placa/{id}")
    public Cliente updatePlaca(@PathVariable UUID id,
                               @Valid @RequestBody ClienteUpdatePlacaForm placaForm){
        return clienteService.updatePlaca(id, placaForm);
    }

    @GetMapping("/{id}")
    public Cliente get(@PathVariable UUID id){
        return clienteService.get(id);
    }

    @GetMapping("/buscarNome")
    public List<Cliente> getByName(@RequestParam String nome){
        return clienteService.getByName(nome);
    }

    @GetMapping("/buscarPlaca")
    public List<Cliente> getByPlacaCarro(@RequestParam String placaCarro){
        return clienteService.getByPlacaCarro(placaCarro);
    }

    @GetMapping("/buscarPrimeiroNome")
    public List<Cliente> getByFirstName(@RequestParam String nome){
        return clienteService.getByFirstName(nome);
    }

    @GetMapping("/registros")
    public List<Vaga>getVagaClienteId(@RequestParam UUID id){
        return clienteService.getVagasClienteId(id);
    }

    @GetMapping("/vagasdisponiveis")
    public String vagasDisponiveis(){
        return vagaService.vagasDisponiveis();
    }

}
