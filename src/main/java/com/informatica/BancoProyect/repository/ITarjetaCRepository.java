package com.informatica.BancoProyect.repository;

import com.informatica.BancoProyect.models.TarjetaClientes;

import java.util.List;

public interface ITarjetaCRepository {
    public List<TarjetaClientes> findAll();
    public int save(TarjetaClientes tarjetaClientes);
    public int update(TarjetaClientes tarjetaClientes);
}
