package com.informatica.BancoProyect.service;

import com.informatica.BancoProyect.models.Clientes;

import java.util.List;

public interface IClientesService {
    public List<Clientes> findAll();
    public int save(Clientes clientes);
    public int update(Clientes clientes);
}
