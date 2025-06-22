package com.ps.Gestion_hoteles.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "tipo_habitacion")
@Data
public class TipoHabitacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tipo_hab_id")
    private long tipo_hab_id;

    @Column(name = "tipo_hab_nombre")
    private String tipo_hab_nombre;

    @Column(name = "tipo_hab_precio")
    private String tipo_hab_precio;
}
