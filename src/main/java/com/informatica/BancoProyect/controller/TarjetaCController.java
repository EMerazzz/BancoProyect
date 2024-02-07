package com.informatica.BancoProyect.controller;

import com.informatica.BancoProyect.models.Clientes;
import com.informatica.BancoProyect.models.ServiceResponse;
import com.informatica.BancoProyect.models.TarjetaClientes;
import com.informatica.BancoProyect.service.IClientesService;
import com.informatica.BancoProyect.service.ITarjetaCService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("API/tarjetaClientes")
@CrossOrigin("*")
public class TarjetaCController {
    @Autowired
    private ITarjetaCService iTarjetaCService;

    @GetMapping("/list")
    public ResponseEntity<List<TarjetaClientes>> list (){
        var result = iTarjetaCService.findAll();
        return new ResponseEntity<>(result, HttpStatus.OK);

    }
    @PostMapping("/save")
    public ResponseEntity<ServiceResponse> save(@RequestBody TarjetaClientes tarjetaClientes){
        ServiceResponse serviceResponse = new ServiceResponse();
        int result = iTarjetaCService.save(tarjetaClientes);
        if (result == 1){
            serviceResponse.setMessage("Agregado exitosamente");

        }
        return new ResponseEntity<>(serviceResponse, HttpStatus.OK);

    }

    @PutMapping("/update")
    public ResponseEntity<ServiceResponse> update(@RequestBody TarjetaClientes tarjetaClientes){
        ServiceResponse serviceResponse = new ServiceResponse();
        int result = iTarjetaCService.update(tarjetaClientes);
        if (result == 1){
            serviceResponse.setMessage("Actualizado exitosamente");

        }
        return new ResponseEntity<>(serviceResponse, HttpStatus.OK);

    }

}
