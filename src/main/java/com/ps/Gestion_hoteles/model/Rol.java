package com.ps.Gestion_hoteles.model;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Entity
@Table(name = "rol")
@Data
public class Rol implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rol_id")
    private Long rol_id;

    @Column(nullable = false, name = "nombre", unique = true)
    private String rol_nombre;
}
