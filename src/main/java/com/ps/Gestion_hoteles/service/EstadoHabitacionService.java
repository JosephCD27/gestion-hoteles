package com.ps.Gestion_hoteles.service;

import com.ps.Gestion_hoteles.model.EstadoHabitacion;
import com.ps.Gestion_hoteles.repository.EstadoHabitacionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EstadoHabitacionService {
    private EstadoHabitacionRepository estadoHabitacionRepository;

    public List<EstadoHabitacion> findAll(){
        List<EstadoHabitacion> estados = estadoHabitacionRepository.findAll();
        return estados;
    }

    public Optional<EstadoHabitacion> findById(long id){
        return estadoHabitacionRepository.findById(id);
    }
}
