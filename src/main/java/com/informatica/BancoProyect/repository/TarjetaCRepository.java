package com.informatica.BancoProyect.repository;

import com.informatica.BancoProyect.models.TarjetaClientes;
import com.informatica.BancoProyect.models.TipoTarjeta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class TarjetaCRepository implements ITarjetaCRepository{
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public List<TarjetaClientes> findAll() {
        String SQL = "SELECT * FROM tarjetasClientes";

        return jdbcTemplate.query(SQL, BeanPropertyRowMapper.newInstance(TarjetaClientes.class));
    }

    @Override
    public int save(TarjetaClientes tarjetaClientes) {
        String SQL = "INSERT INTO `banco`.`tarjetasClientes` (`codCLiente`, `codTipoTarjeta`) " +
                "VALUES (?,?);";
        return jdbcTemplate.update(SQL, new Object[]{
                tarjetaClientes.getCodCLiente(),
                tarjetaClientes.getCodTipoTarjeta()

        });
    }

    @Override
    public int update(TarjetaClientes tarjetaClientes) {
        String SQL = "UPDATE tarjetasClientes set codCLiente=?,codTipoTarjeta=? where codTarjetaCliente=?";

        return jdbcTemplate.update(SQL, new Object[]{
                tarjetaClientes.getCodCLiente(),
                tarjetaClientes.getCodTipoTarjeta(),
               tarjetaClientes.getCodTarjetaCliente()

        });
    }
}
