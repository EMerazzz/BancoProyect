package com.informatica.BancoProyect.service;

import com.informatica.BancoProyect.models.TarjetaClientes;
import com.informatica.BancoProyect.models.TipoTarjeta;
import com.informatica.BancoProyect.repository.ITarjetaCRepository;
import com.informatica.BancoProyect.repository.ITipoTRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TarjetaCService implements ITarjetaCService{
    private final ITarjetaCRepository iTarjetaCRepository;
    @Autowired
    public TarjetaCService(ITarjetaCRepository iTarjetaCRepository) {
        this.iTarjetaCRepository = iTarjetaCRepository;
    }
    @Override
    public List<TarjetaClientes> findAll() {
        List<TarjetaClientes> list;
        try {
            list = iTarjetaCRepository.findAll();
        } catch (Exception ex) {
            throw ex;
        }
        return list;
    }

    @Override
    public int save(TarjetaClientes tarjetaClientes) {
        int row;
        try {
            row = iTarjetaCRepository.save(tarjetaClientes);
        } catch (Exception ex) {
            throw ex;
        }
        return row;
    }

    @Override
    public int update(TarjetaClientes tarjetaClientes) {
        int row;
        try {
            row = iTarjetaCRepository.update(tarjetaClientes);
        } catch (Exception ex) {
            throw ex;
        }
        return row;
    }
}
