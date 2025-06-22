package com.ps.Gestion_hoteles.controller;

import com.ps.Gestion_hoteles.model.EstadoHabitacion;
import com.ps.Gestion_hoteles.service.EstadoHabitacionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/estado-habitacion")
@RequiredArgsConstructor
public class EstadoHabitacionController {
    private final EstadoHabitacionService estadoHabitacionService;

    @GetMapping("/all")
    public List<EstadoHabitacion> listarEstadoHab(){
        List<EstadoHabitacion> estados = estadoHabitacionService.findAll();
        return estados;
    }

    @GetMapping("/{id}")
    public ResponseEntity<EstadoHabitacion> obtenerEstadoHab(@PathVariable long id){
        EstadoHabitacion estado = estadoHabitacionService.findById(id).get();
        return ResponseEntity.ok(estado);
    }
}
