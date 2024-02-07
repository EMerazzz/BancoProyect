package com.informatica.BancoProyect.repository;

import com.informatica.BancoProyect.models.Clientes;
import com.informatica.BancoProyect.models.TipoTarjeta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class TipoTRespository implements ITipoTRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;  // Corregir el nombre del atributo
    @Override
    public List<TipoTarjeta> findAll() {
        String SQL = "SELECT * FROM tipoTarjeta";
        return jdbcTemplate.query(SQL, BeanPropertyRowMapper.newInstance(TipoTarjeta.class));
    }

    @Override
    public int save(TipoTarjeta tipoTarjeta) {
        String SQL = "INSERT INTO `banco`.`tipoTarjeta` (`nombreTarjeta`, `restriccionCredito`) " +
                "VALUES (?,?);";
        return jdbcTemplate.update(SQL, new Object[]{
                tipoTarjeta.getNombreTarjeta(),
                tipoTarjeta.getRestriccionCredito()

        });
    }

    @Override
    public int update(TipoTarjeta tipoTarjeta) {
        String SQL = "UPDATE tipoTarjeta set nombreTarjeta=?,restriccionCredito=? where codTipoTarjeta=?";

        return jdbcTemplate.update(SQL, new Object[]{
                tipoTarjeta.getNombreTarjeta(),
                tipoTarjeta.getRestriccionCredito(),
                tipoTarjeta.getCodTipoTarjeta()

        });
    }
}
