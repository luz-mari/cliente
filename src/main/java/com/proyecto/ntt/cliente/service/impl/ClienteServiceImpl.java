package com.proyecto.ntt.cliente.service.impl;

import com.proyecto.ntt.cliente.controller.dto.Cliente;
import com.proyecto.ntt.cliente.service.ClienteService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServiceImpl  implements ClienteService {

    @Override
    public List<Cliente> listadeCliente() {
        return List.of();
    }

    @Override
    public Cliente registrar(Cliente a) {
        return null;
    }

    @Override
    public Cliente actualizar(Cliente a) {
        return null;
    }

    @Override
    public void eliminar(Integer id) {
    }

}
