package com.informatica.BancoProyect.repository;

import com.informatica.BancoProyect.models.TipoTarjeta;

import java.util.List;

public interface ITipoTRepository {
    public List<TipoTarjeta> findAll();
    public int save(TipoTarjeta tipoTarjeta);


    public int update(TipoTarjeta tipoTarjeta);
}
