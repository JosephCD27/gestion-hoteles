package com.ps.Gestion_hoteles.controller;

import com.ps.Gestion_hoteles.model.TipoHabitacion;
import com.ps.Gestion_hoteles.service.TipoHabitacionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tipo-habitacion")
@RequiredArgsConstructor
public class TipoHabitacionController {

    private final TipoHabitacionService tipoHabitacionService;

    @GetMapping("/all")
    public List<TipoHabitacion> listarTipoHab(){
        List<TipoHabitacion> tipos = tipoHabitacionService.findAll();
        return tipos;
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoHabitacion> obtenerTipoHab(@PathVariable long id){
        TipoHabitacion tipo = tipoHabitacionService.findById(id).get();
        return ResponseEntity.ok(tipo);
    }
}
