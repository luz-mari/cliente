package com.proyecto.ntt.cliente.service.impl;

import com.proyecto.ntt.cliente.controller.dto.Cliente;
import com.proyecto.ntt.cliente.repository.ClienteRepository;
import com.proyecto.ntt.cliente.repository.dao.ClienteDao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ClienteServiceImplTest {

    @Mock
    private ClienteRepository repository;

    @InjectMocks
    private ClienteServiceImpl service;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this); // Inicializa los mocks
    }

    @Test
    void testListadeCliente() {
        // Datos simulados
        ClienteDao clienteDao1 = new ClienteDao();
        clienteDao1.setId_cliente(1);
        clienteDao1.setNombre("Juan");
        clienteDao1.setApellido("Pérez");
        clienteDao1.setDni("12345678");
        clienteDao1.setCorreo("juan.perez@example.com");

        ClienteDao clienteDao2 = new ClienteDao();
        clienteDao2.setId_cliente(2);
        clienteDao2.setNombre("Ana");
        clienteDao2.setApellido("López");
        clienteDao2.setDni("87654321");
        clienteDao2.setCorreo("ana.lopez@example.com");

        when(repository.findAll()).thenReturn(List.of(clienteDao1, clienteDao2));

        // Ejecución del método
        List<Cliente> result = service.listadeCliente();

        // Validaciones
        assertNotNull(result);
        assertEquals(2, result.size());

        Cliente cliente1 = result.get(0);
        assertEquals("Juan", cliente1.getNombre());
        assertEquals("Pérez", cliente1.getApellido());
    }

    @Test
    void testObtenerCliente() {
        // Datos simulados
        ClienteDao clienteDao = new ClienteDao();
        clienteDao.setId_cliente(1);
        clienteDao.setNombre("Juan");
        clienteDao.setApellido("Pérez");
        clienteDao.setDni("12345678");
        clienteDao.setCorreo("juan.perez@example.com");

        when(repository.findById(1)).thenReturn(Optional.of(clienteDao));

        // Ejecución del método
        Cliente result = service.obtenerCliente(1);

        // Validaciones
        assertNotNull(result);
        assertEquals("Juan", result.getNombre());
        assertEquals("Pérez", result.getApellido());
    }

    @Test
    void testRegistrar() {
        // Datos simulados
        Cliente cliente = new Cliente();
        cliente.setNombre("Juan");
        cliente.setApellido("Pérez");
        cliente.setDni("12345678");
        cliente.setEmail("juan.perez@example.com");

        ClienteDao clienteDao = new ClienteDao();
        clienteDao.setId_cliente(1);
        clienteDao.setNombre("Juan");
        clienteDao.setApellido("Pérez");
        clienteDao.setDni("12345678");
        clienteDao.setCorreo("juan.perez@example.com");

        when(repository.save(any(ClienteDao.class))).thenReturn(clienteDao);

        // Ejecución del método
        Cliente result = service.registrar(cliente);

        // Validaciones
        assertNotNull(result);
        assertEquals("Juan", result.getNombre());
        assertEquals("Pérez", result.getApellido());
    }

    @Test
    void testActualizar() {
        // Datos simulados
        Cliente cliente = new Cliente();
        cliente.setId(1);
        cliente.setNombre("Juan");
        cliente.setApellido("Pérez");
        cliente.setDni("12345678");
        cliente.setEmail("juan.perez@example.com");

        ClienteDao clienteDao = new ClienteDao();
        clienteDao.setId_cliente(1);
        clienteDao.setNombre("Juan");
        clienteDao.setApellido("Pérez");
        clienteDao.setDni("12345678");
        clienteDao.setCorreo("juan.perez@example.com");

        when(repository.save(any(ClienteDao.class))).thenReturn(clienteDao);

        // Ejecución del método
        Cliente result = service.actualizar(cliente);

        // Validaciones
        assertNotNull(result);
        assertEquals("Juan", result.getNombre());
        assertEquals("Pérez", result.getApellido());
    }

    @Test
    void testEliminar() {
        // Datos simulados
        ClienteDao clienteDao = new ClienteDao();
        clienteDao.setId_cliente(1);

        when(repository.findById(1)).thenReturn(Optional.of(clienteDao));
        doNothing().when(repository).delete(clienteDao);

        // Ejecución del método
        service.eliminar(1);

        // Verificar que el método delete fue llamado
        verify(repository, times(1)).delete(clienteDao);
    }
}
