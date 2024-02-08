package com.informatica.BancoProyect.repository;

import com.informatica.BancoProyect.models.Clientes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class ClientesRepository implements IClientesRepository{
    @Autowired
    private JdbcTemplate jdbcTemplate;  // Corregir el nombre del atributo
    @Override
    public List<Clientes> findAll() {
        String SQL = "SELECT * FROM clientes";
        return jdbcTemplate.query(SQL, BeanPropertyRowMapper.newInstance(Clientes.class));
    }

    @Override
    public int save(Clientes clientes) {
        String SQL = "INSERT INTO `banco`.`clientes` (`usuario`, `primerNombre`, `segundoNombre`, `primerApellido`, `SegundoApellido`, `Telefono`, `direccion`, `correo`, `paisResidencia`) " +
                "VALUES (?,?, ?,?, ?, ?, ?, ?, ?);";
        return jdbcTemplate.update(SQL, new Object[]{
                clientes.getUsuario(),
                clientes.getPrimerNombre(),
                clientes.getSegundoNombre(),
                clientes.getPrimerNombre(),
                clientes.getSegundoApellido(),
                clientes.getTelefono(),
                clientes.getDireccion(),
                clientes.getCorreo(),
                clientes.getPaisResidencia(),

        });
    }

    @Override
    public int update(Clientes clientes) {
        String SQL = "UPDATE CLIENTES set usuario=?,primerNombre=?,segundoNombre=?,primerApellido=?,segundoApellido=?,Telefono=?," +
                "direccion=?,correo=?, paisResidencia=? WHERE codCliente=?";
        return jdbcTemplate.update(SQL, new Object[]{
                clientes.getUsuario(),
                clientes.getPrimerNombre(),
                clientes.getSegundoNombre(),
                clientes.getPrimerApellido(),
                clientes.getSegundoApellido(),
                clientes.getTelefono(),
                clientes.getDireccion(),
                clientes.getCorreo(),
                clientes.getPaisResidencia(),
                clientes.getCodCliente()

        });
    }
  
}
