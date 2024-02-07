package com.informatica.BancoProyect.models;

import lombok.Data;

@Data
public class Clientes {

    int codCliente;
    String Usuario;
    String PrimerNombre;
    String SegundoNombre;
    String PrimerApellido;
    String  SegundoApellido;
    String Telefono;
    String Direccion;
    String Correo;
    String PaisResidencia;
}
