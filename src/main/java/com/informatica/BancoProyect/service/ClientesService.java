package com.informatica.BancoProyect.service;

import com.informatica.BancoProyect.models.Clientes;
import com.informatica.BancoProyect.repository.IClientesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ClientesService implements IClientesService{
    private final IClientesRepository iClientesRepository;

   @Autowired
    public ClientesService(IClientesRepository iClientesRepository) {
        this.iClientesRepository = iClientesRepository;
    }
    @Override
    public List<Clientes> findAll() {
        List<Clientes> list;
        try {
            list = iClientesRepository.findAll();
        } catch (Exception ex) {
            throw ex;
        }
        return list;
    }

    @Override
    public int save(Clientes clientes) {
        int row;
        try {
            row = iClientesRepository.save(clientes);
        } catch (Exception ex) {
            throw ex;
        }
        return row;
    }

    @Override
    public int update(Clientes clientes) {
        int row;
        try {
            row = iClientesRepository.update(clientes);
        } catch (Exception ex) {
            throw ex;
        }
        return row;
    }
    @Override
    public Clientes findbyUser(String usuario) {
        return iClientesRepository.findbyUser(usuario);
    }
}

