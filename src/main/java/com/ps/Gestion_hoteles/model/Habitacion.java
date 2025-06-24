package com.ps.Gestion_hoteles.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "habitaciones")
@Data
public class Habitacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "habitacion_id", nullable = false)
    private long habitacion_id;

    @Column(name = "habitacion_consecutivo", nullable = false)
    private String habitacion_consecutivo;

    @Column(name = "habitacion_capacidad", nullable = false)
    private int habitacion_capacidad;

    @Column(name = "habitacion_piso", nullable = false)
    private int habitacion_piso;

    @Column(name = "habitacion_creacion", nullable = false, updatable = false)
    private LocalDateTime habitacion_creacion;

    @PrePersist
    protected void onCreate() {
        this.habitacion_creacion = LocalDateTime.now();
    }

    @ManyToOne
    @JoinColumn(name = "hotel_id", nullable = false)
    private Hotel hotel;

    @ManyToOne
    @JoinColumn(name = "tipo_hab_id", nullable = false)
    private TipoHabitacion tipoHabitacion;

    @ManyToOne
    @JoinColumn(name = "estado_hab_id", nullable = false)
    private EstadoHabitacion estadoHabitacion;
}
