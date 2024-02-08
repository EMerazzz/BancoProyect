package com.informatica.BancoProyect.repository;

import com.informatica.BancoProyect.models.Clientes;

import java.util.List;

public interface IClientesRepository {
    public List<Clientes> findAll();
    public int save(Clientes clientes);
    public int update(Clientes clientes);

}
