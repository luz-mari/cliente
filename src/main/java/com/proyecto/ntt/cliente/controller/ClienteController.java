package com.proyecto.ntt.cliente.controller;

import com.proyecto.ntt.cliente.controller.dto.Cliente;
import com.proyecto.ntt.cliente.service.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
@RequiredArgsConstructor
public class ClienteController {

    private final ClienteService service;

    @GetMapping
    public List<Cliente> listadeCliente(){
        return service.listadeCliente();
    }

    @PostMapping
    public Cliente registrar(@RequestBody Cliente a){
        return service.registrar(a);
    }

    @PutMapping
    public Cliente actualizar (@RequestBody Cliente b){
        return service.actualizar(b);
    }

    @DeleteMapping("{id}")
    public void eliminar (@PathVariable Integer id){
         service.eliminar(id);

    }
}
