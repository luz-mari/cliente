package com.proyecto.ntt.cliente.repository.dao;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="cliente")
public class ClienteDao {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id_cliente;
    private String nombre;
    private String correo;
    private String apellido;
    private String dni;

}


