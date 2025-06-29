package com.ps.Gestion_hoteles.service;

import com.ps.Gestion_hoteles.model.Usuario;
import com.ps.Gestion_hoteles.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    // Obtener todos los usuarios
    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    // Obtener un usuario por ID
    public Optional<Usuario> findById(long id) {
        return usuarioRepository.findById(id);
    }
    // Obtener un usuario por username
    public Optional<Usuario> buscarPorUsername(String username) {
        return usuarioRepository.buscarUsuarioPorUsername(username);
    }

    // Registrar un nuevo usuario
    public Usuario save(Usuario usuario) {
        if (usuario.getUsuario_username() == null || usuario.getUsuario_username().isBlank()) {
            throw new RuntimeException("El nombre de usuario es obligatorio");
        }

        if (usuario.getUsuario_password() == null || usuario.getUsuario_password().isBlank()) {
            throw new RuntimeException("La contraseña es obligatoria");
        }

        return usuarioRepository.save(usuario);
    }

    // Actualizar usuario
    public Usuario update(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    // Eliminar usuario por ID
    public void delete(long id) {
        var usuario = findById(id).get();

        if (usuario != null) {
            usuarioRepository.delete(usuario);
        }
    }
}

