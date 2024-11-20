package com.proyecto.ntt.cliente.service.impl;

import com.proyecto.ntt.cliente.controller.dto.Cliente;
import com.proyecto.ntt.cliente.repository.ClienteRepository;
import com.proyecto.ntt.cliente.repository.dao.ClienteDao;
import com.proyecto.ntt.cliente.service.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.StreamSupport;

@RequiredArgsConstructor
@Service
public class ClienteServiceImpl  implements ClienteService {

    private final ClienteRepository repository;

    @Override
    public List<Cliente> listadeCliente() {
        return StreamSupport.stream(repository.findAll().spliterator(), false)
                .map(clienteDaos -> {
                    Cliente cliente = new Cliente();
                    cliente.setApellido(clienteDaos.getApellido());
                    cliente.setNombre(clienteDaos.getNombre());
                    cliente.setDni(clienteDaos.getDni());
                    cliente.setEmail(clienteDaos.getCorreo());
                    cliente.setId(clienteDaos.getId_cliente());
                    return cliente;
                }).toList();
    }

    @Override
    public Cliente obtenerCliente(Integer id) {
        var clienteEncontrado = repository.findById(id);
        if (clienteEncontrado.isPresent()){
            var cliente = new Cliente();
            var clienteDao = clienteEncontrado.get();
            cliente.setId(clienteDao.getId_cliente());
            cliente.setNombre(clienteDao.getNombre());
            cliente.setApellido(clienteDao.getApellido());
            cliente.setDni(clienteDao.getDni());
            cliente.setEmail(clienteDao.getCorreo());
            return cliente;
        } else{
            return null;
        }
    }

    @Override
    public Cliente registrar(Cliente a) {
        var clienteDao = new ClienteDao();
        clienteDao.setNombre(a.getNombre());
        clienteDao.setDni(a.getDni());
        clienteDao.setCorreo(a.getEmail());
        clienteDao.setApellido(a.getApellido());
        var clienteGuardado = repository.save(clienteDao);
        Cliente cliente = new Cliente();
        cliente.setApellido(clienteDao.getApellido());
        cliente.setNombre(clienteDao.getNombre());
        cliente.setDni(clienteDao.getDni());
        cliente.setEmail(clienteDao.getCorreo());
        cliente.setId(clienteDao.getId_cliente());
        return cliente;

    }

    @Override
    public Cliente actualizar(Cliente a) {
        var clienteDao = new ClienteDao();
        clienteDao.setId_cliente(a.getId());
        clienteDao.setNombre(a.getNombre());
        clienteDao.setDni(a.getDni());
        clienteDao.setCorreo(a.getEmail());
        clienteDao.setApellido(a.getApellido());
        var clienteGuardado = repository.save(clienteDao);
        Cliente cliente = new Cliente();
        cliente.setApellido(clienteDao.getApellido());
        cliente.setNombre(clienteDao.getNombre());
        cliente.setDni(clienteDao.getDni());
        cliente.setEmail(clienteDao.getCorreo());
        cliente.setId(clienteDao.getId_cliente());
        return cliente;
    }

    @Override
    public void eliminar(Integer id) {
        var clienteEncontrado = repository.findById(id);
        if (clienteEncontrado.isPresent()){
            repository.delete(clienteEncontrado.get());
        }
    }

}
