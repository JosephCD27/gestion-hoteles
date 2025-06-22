package com.ps.Gestion_hoteles.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "hoteles")
@Data
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hotel_id", nullable = false)
    private long hotel_id;

    @Column(name = "hotel_nombre", nullable = false)
    private String hotel_nombre;

    @Column(name = "hotel_direccion", nullable = false)
    private String hotel_direccion;

    @Column(name = "hotel_ciudad", nullable = false)
    private String hotel_ciudad;

    @Column(name = "hotel_creacion", nullable = false, updatable = false)
    private LocalDateTime hotel_creacion;

    @PrePersist
    protected void onCreate(){
        this.hotel_creacion = LocalDateTime.now();
    }
}
