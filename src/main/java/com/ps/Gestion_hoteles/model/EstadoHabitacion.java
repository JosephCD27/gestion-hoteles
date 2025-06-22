package com.ps.Gestion_hoteles.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "estado_habitacion")
@Data
public class EstadoHabitacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "estado_hab_id")
    private long estado_hab_id;

    @Column(name = "estado_hab_nombre")
    private String estado_hab_nombre;
}
