package com.proyecto.ntt.cliente.repository.dao;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Data

@Document(collection="cliente")
public class ClienteDao {
    @Id
    private Integer id_cliente= UUID.randomUUID().hashCode();
    private String nombre;
    private String correo;
    private String apellido;
    private String dni;

}


