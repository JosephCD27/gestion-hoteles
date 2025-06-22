package com.ps.Gestion_hoteles.service;

import com.ps.Gestion_hoteles.model.TipoHabitacion;
import com.ps.Gestion_hoteles.repository.TipoHabitacionRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TipoHabitacionService {
    private TipoHabitacionRepository tipoHabitacionRepository;

    public List<TipoHabitacion> findAll(){
        List<TipoHabitacion> tiposHabitacion = tipoHabitacionRepository.findAll();
        return tiposHabitacion;
    }

    public Optional<TipoHabitacion> findById(long id){
        return tipoHabitacionRepository.findById(id);
    }
}
