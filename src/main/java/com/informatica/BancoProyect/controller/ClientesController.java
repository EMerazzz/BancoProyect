package com.informatica.BancoProyect.controller;

import com.informatica.BancoProyect.models.Clientes;
import com.informatica.BancoProyect.models.ServiceResponse;
import com.informatica.BancoProyect.service.IClientesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("API/clientes")
@CrossOrigin("*")
public class ClientesController {
    @Autowired
    private IClientesService iClientesService;
    @GetMapping("/list")
    public ResponseEntity<List<Clientes>> list (){
        var result = iClientesService.findAll();
        return new ResponseEntity<>(result, HttpStatus.OK);

    }

    @PostMapping("/save")
    public ResponseEntity<ServiceResponse> save(@RequestBody Clientes clientes){
        ServiceResponse serviceResponse = new ServiceResponse();
        int result = iClientesService.save(clientes);
        if (result == 1){
            serviceResponse.setMessage("Agregado exitosamente");

        }
        return new ResponseEntity<>(serviceResponse, HttpStatus.OK);

    }
    @PutMapping("/update")
    public ResponseEntity<ServiceResponse> update(@RequestBody Clientes clientes){
        ServiceResponse serviceResponse = new ServiceResponse();
        int result = iClientesService.update(clientes);
        if (result == 1){
            serviceResponse.setMessage("Actualizado exitosamente");

        }
        return new ResponseEntity<>(serviceResponse, HttpStatus.OK);

    }

}

