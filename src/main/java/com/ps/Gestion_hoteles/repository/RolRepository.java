package com.ps.Gestion_hoteles.repository;

import com.ps.Gestion_hoteles.model.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolRepository extends JpaRepository<Rol, Long> {
}
