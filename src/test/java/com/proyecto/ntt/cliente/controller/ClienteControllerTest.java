package com.proyecto.ntt.cliente.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.proyecto.ntt.cliente.controller.dto.Cliente;
import com.proyecto.ntt.cliente.service.ClienteService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class ClienteControllerTest {

    @Mock
    private ClienteService service;

    @InjectMocks
    private ClienteController controller;

    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
        objectMapper = new ObjectMapper();
    }

    @Test
    void testListadeCliente() throws Exception {
        // Datos simulados
        Cliente cliente1 = new Cliente();
        cliente1.setId(1);
        cliente1.setNombre("Juan");
        cliente1.setApellido("Pérez");
        cliente1.setDni("12345678");
        cliente1.setEmail("juan.perez@example.com");

        Cliente cliente2 = new Cliente();
        cliente2.setId(2);
        cliente2.setNombre("Ana");
        cliente2.setApellido("López");
        cliente2.setDni("87654321");
        cliente2.setEmail("ana.lopez@example.com");

        when(service.listadeCliente()).thenReturn(List.of(cliente1, cliente2));

        // Ejecución y validaciones
        mockMvc.perform(get("/clientes"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].nombre").value("Juan"))
                .andExpect(jsonPath("$[1].nombre").value("Ana"));

        verify(service, times(1)).listadeCliente();
    }

    @Test
    void testObtenerCliente() throws Exception {
        // Datos simulados
        Cliente cliente = new Cliente();
        cliente.setId(1);
        cliente.setNombre("Juan");
        cliente.setApellido("Pérez");
        cliente.setDni("12345678");
        cliente.setEmail("juan.perez@example.com");

        when(service.obtenerCliente(1)).thenReturn(cliente);

        // Ejecución y validaciones
        mockMvc.perform(get("/clientes/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.nombre").value("Juan"))
                .andExpect(jsonPath("$.apellido").value("Pérez"));

        verify(service, times(1)).obtenerCliente(1);
    }

    @Test
    void testRegistrar() throws Exception {
        // Datos simulados
        Cliente cliente = new Cliente();
        cliente.setNombre("Juan");
        cliente.setApellido("Pérez");
        cliente.setDni("12345678");
        cliente.setEmail("juan.perez@example.com");

        Cliente clienteRegistrado = new Cliente();
        clienteRegistrado.setId(1);
        clienteRegistrado.setNombre("Juan");
        clienteRegistrado.setApellido("Pérez");
        clienteRegistrado.setDni("12345678");
        clienteRegistrado.setEmail("juan.perez@example.com");

        when(service.registrar(any(Cliente.class))).thenReturn(clienteRegistrado);

        // Ejecución y validaciones
        mockMvc.perform(post("/clientes")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(cliente)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.nombre").value("Juan"));

        verify(service, times(1)).registrar(any(Cliente.class));
    }

    @Test
    void testActualizar() throws Exception {
        // Datos simulados
        Cliente cliente = new Cliente();
        cliente.setId(1);
        cliente.setNombre("Juan");
        cliente.setApellido("Pérez");
        cliente.setDni("12345678");
        cliente.setEmail("juan.perez@example.com");

        when(service.actualizar(any(Cliente.class))).thenReturn(cliente);

        // Ejecución y validaciones
        mockMvc.perform(put("/clientes")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(cliente)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.nombre").value("Juan"));

        verify(service, times(1)).actualizar(any(Cliente.class));
    }

    @Test
    void testEliminar() throws Exception {
        doNothing().when(service).eliminar(1);

        // Ejecución
        mockMvc.perform(delete("/clientes/1"))
                .andExpect(status().isOk());

        verify(service, times(1)).eliminar(1);
    }
}
