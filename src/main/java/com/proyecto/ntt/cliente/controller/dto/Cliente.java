package com.proyecto.ntt.cliente.controller.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Data;


@Data
public class Cliente {
    private Integer Id;
    @NotNull
    private String nombre;
    @NotNull
    private String apellido;
    @NotNull
    private String dni;
    @Email
    private String email;
}
