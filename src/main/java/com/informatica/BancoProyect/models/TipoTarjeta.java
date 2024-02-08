package com.informatica.BancoProyect.models;

import lombok.Data;
import java.math.BigDecimal;
@Data
public class TipoTarjeta {
   int codTipoTarjeta;
   String nombreTarjeta;
   int RestriccionCredito;
}
