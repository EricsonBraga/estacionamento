package com.estacionamento.estacionamento.service;

import com.estacionamento.estacionamento.entity.Cliente;
import com.estacionamento.estacionamento.entity.Vaga;
import com.estacionamento.estacionamento.entity.form.ClienteForm;
import com.estacionamento.estacionamento.entity.form.ClienteUpdateNomeForm;
import com.estacionamento.estacionamento.entity.form.ClienteUpdatePlacaForm;
import com.estacionamento.estacionamento.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente create(ClienteForm form){
        Cliente cliente = new Cliente();
        cliente.setNome(form.getNome());
        cliente.setPlacaCarro(form.getPlacaCarro());

        return clienteRepository.save(cliente);
    }

    public List<Cliente> getAll(){
        return clienteRepository.findAll();
    }

    public void delete(UUID id){
        clienteRepository.deleteById(id);
    }

    public Cliente update(UUID id, ClienteForm form){
        Cliente cliente = clienteRepository.findById(id).get();
        cliente.setNome(form.getNome());
        cliente.setPlacaCarro(form.getPlacaCarro());

        return clienteRepository.save(cliente);
    }

    public Cliente updateName(UUID id, ClienteUpdateNomeForm nomeForm){
        Cliente cliente = clienteRepository.findById(id).get();
        cliente.setNome(nomeForm.getNome());

        return clienteRepository.save(cliente);
    }

    public Cliente updatePlaca(UUID id, ClienteUpdatePlacaForm placaForm){
        Cliente cliente = clienteRepository.findById(id).get();

        cliente.setPlacaCarro(placaForm.getPlacaCarro());

        return clienteRepository.save(cliente);
    }

    public Cliente get(UUID id){
        return clienteRepository.findById(id).get();
    }

    public List<Cliente> getByName(String nome){
        return clienteRepository.findByNome(nome);
    }

    public List<Cliente> getByPlacaCarro(String placaCarro){
        return clienteRepository.findByPlacaCarro(placaCarro);
    }

    public List<Cliente> getByFirstName(String nome){
        return clienteRepository.findByNomeStartingWith(nome);
    }

    public List<Vaga>getVagasClienteId(UUID id){
        Cliente cliente = clienteRepository.findById(id).get();
        return cliente.getVagas();
    }
}
