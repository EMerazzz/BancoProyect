package com.informatica.BancoProyect.service;

import com.informatica.BancoProyect.models.TipoTarjeta;

import java.util.List;

public interface ITipoTService {
    public List<TipoTarjeta> findAll();
    public int save(TipoTarjeta tipoTarjeta);


    public int update(TipoTarjeta tipoTarjeta);
}
