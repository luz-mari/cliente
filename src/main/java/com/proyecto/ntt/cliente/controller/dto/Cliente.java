package com.proyecto.ntt.cliente.controller.dto;

import lombok.Data;


@Data
public class Cliente {
    private Integer Id;
    private String nombre;
    private String apellido;
    private String dni;
    private String email;
}
