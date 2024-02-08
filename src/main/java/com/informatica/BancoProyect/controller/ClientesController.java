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
    @GetMapping("/find/{usuario}")
    public ResponseEntity<Clientes> findByUser(@PathVariable String usuario){

        System.out.println("usuario: " + usuario);
        var result = iClientesService.findbyUser(usuario);

        if(result != null) {
            return new ResponseEntity<>(result, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/save")
    public ResponseEntity<ServiceResponse> save(@RequestBody Clientes clientes){
        ServiceResponse serviceResponse = new ServiceResponse();
      //  System.out.println("data usuario: " + clientes);

        Clientes busquedaCliente=iClientesService.findbyUser(clientes.getUsuario());
        System.out.println("busquedaCliente: " + busquedaCliente);

        if(busquedaCliente!=null)
        {
            serviceResponse.setMessage("Usuario ya existe");
            serviceResponse.setSuccess(false);
        }
        else
        {
            System.out.println("antes del guardado: " + clientes);

            int result = iClientesService.save(clientes);
            if(result == 1){
                serviceResponse.setMessage("Agregado Exitosamente");
                serviceResponse.setSuccess(true);
            }
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

