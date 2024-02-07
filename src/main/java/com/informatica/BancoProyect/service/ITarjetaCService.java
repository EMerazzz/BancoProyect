package com.informatica.BancoProyect.service;

import com.informatica.BancoProyect.models.TarjetaClientes;

import java.util.List;

public interface ITarjetaCService {
    public List<TarjetaClientes> findAll();
    public int save(TarjetaClientes tarjetaClientes);
    public int update(TarjetaClientes tarjetaClientes);
}
