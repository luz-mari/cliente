package com.proyecto.ntt.cliente.service;

import com.proyecto.ntt.cliente.controller.dto.Cliente;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface ClienteService {
    List<Cliente>listadeCliente();
    Cliente registrar(Cliente a);
    Cliente actualizar(Cliente a);
    void eliminar( Integer id);

}
