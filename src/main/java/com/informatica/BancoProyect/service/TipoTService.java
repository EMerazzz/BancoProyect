package com.informatica.BancoProyect.service;

import com.informatica.BancoProyect.models.Clientes;
import com.informatica.BancoProyect.models.TipoTarjeta;
import com.informatica.BancoProyect.repository.IClientesRepository;
import com.informatica.BancoProyect.repository.ITipoTRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TipoTService implements ITipoTService{
    private final ITipoTRepository iTipoTRepository;

    @Autowired
    public TipoTService(ITipoTRepository iTipoTRepository) {
        this.iTipoTRepository = iTipoTRepository;
    }
    @Override
    public List<TipoTarjeta> findAll() {
        List<TipoTarjeta> list;
        try {
            list = iTipoTRepository.findAll();
        } catch (Exception ex) {
            throw ex;
        }
        return list;
    }

    @Override
    public int save(TipoTarjeta tipoTarjeta) {
        int row;
        try {
            row = iTipoTRepository.save(tipoTarjeta);
        } catch (Exception ex) {
            throw ex;
        }
        return row;
    }

    @Override
    public int update(TipoTarjeta tipoTarjeta) {
        int row;
        try {
            row = iTipoTRepository.update(tipoTarjeta);
        } catch (Exception ex) {
            throw ex;
        }
        return row;
    }
}
