package com.informatica.BancoProyect.controller;


import com.informatica.BancoProyect.models.ServiceResponse;
import com.informatica.BancoProyect.models.TipoTarjeta;

import com.informatica.BancoProyect.service.ITipoTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("API/tipoTarjeta")
@CrossOrigin("*")
public class TipoTController {
    @Autowired
    private ITipoTService iTipoTService;
    @GetMapping("/list")
    public ResponseEntity<List<TipoTarjeta>> list (){
        var result = iTipoTService.findAll();
        return new ResponseEntity<>(result, HttpStatus.OK);

    }
    @PostMapping("/save")
    public ResponseEntity<ServiceResponse> save(@RequestBody TipoTarjeta tipoTarjeta){
        ServiceResponse serviceResponse = new ServiceResponse();
        int result = iTipoTService.save(tipoTarjeta);
        if (result == 1){
            serviceResponse.setMessage("Agregado exitosamente");

        }
        return new ResponseEntity<>(serviceResponse, HttpStatus.OK);

    }

    @PutMapping("/update")
    public ResponseEntity<ServiceResponse> update(@RequestBody TipoTarjeta tipoTarjeta){
        ServiceResponse serviceResponse = new ServiceResponse();
        int result = iTipoTService.update(tipoTarjeta);
        if (result == 1){
            serviceResponse.setMessage("Actualizado exitosamente");

        }
        return new ResponseEntity<>(serviceResponse, HttpStatus.OK);

    }
}
