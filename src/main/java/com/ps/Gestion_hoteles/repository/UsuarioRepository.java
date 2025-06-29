package com.ps.Gestion_hoteles.repository;

import com.ps.Gestion_hoteles.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    // obtener usuario por username
    @Query("SELECT u FROM Usuario u WHERE u.usuario_username = :username")
    Optional<Usuario> buscarUsuarioPorUsername(String username);

}
