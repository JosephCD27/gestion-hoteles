package com.ps.Gestion_hoteles.service;

import com.ps.Gestion_hoteles.model.Rol;
import com.ps.Gestion_hoteles.repository.RolRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RolService {

    private final RolRepository rolRepository;

    // obtener roles
    public List<Rol> findAll() {
        return rolRepository.findAll();
    }

    // obtener rol por ID
    public Optional<Rol> findById(long id) {
        return rolRepository.findById(id);
    }

    // registrar nuevo rol
    public Rol save(Rol rol) throws RuntimeException {
        if (rol.getRol_nombre() == null || rol.getRol_nombre().isEmpty()) {
            throw new RuntimeException("El nombre del rol es obligatorio");
        }

        return rolRepository.save(rol);
    }

    // actualizar rol
    public Rol update(Rol rol) {
        return rolRepository.save(rol);
    }

    // eliminar rol
    public void delete(long id) {
        var rol = findById(id).get();
        if (rol != null) {
            rolRepository.delete(rol);
        }
    }
}
