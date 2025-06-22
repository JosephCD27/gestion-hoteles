package com.ps.Gestion_hoteles.repository;

import com.ps.Gestion_hoteles.model.EstadoHabitacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoHabitacionRepository extends JpaRepository<EstadoHabitacion, Long> {
}
