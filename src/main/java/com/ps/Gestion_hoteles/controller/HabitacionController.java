package com.ps.Gestion_hoteles.controller;

import com.ps.Gestion_hoteles.model.Habitacion;
import com.ps.Gestion_hoteles.service.HabitacionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/habitaciones")
@RequiredArgsConstructor
public class HabitacionController {
    private final HabitacionService habitacionService;

    @GetMapping("/all")
    public List<Habitacion> listarHabitaciones(){
        List<Habitacion> habitaciones = habitacionService.findAll();
        return habitaciones;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Habitacion> obtenerHabitacion(@PathVariable long id){
        Habitacion habitacion = habitacionService.findById(id).get();
        return ResponseEntity.ok(habitacion);
    }

    @PostMapping
    public ResponseEntity<?> crearHabitacion(@RequestBody Habitacion habitacion){
        try{
            return ResponseEntity.ok(habitacionService.save(habitacion));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Habitacion> actualizarHabitacion(@PathVariable long id, @RequestBody Habitacion habitacion){
        if (id != habitacion.getHabitacion_id()){
            return ResponseEntity.badRequest().build();
        }

        Habitacion updt = habitacionService.update(habitacion);
        return ResponseEntity.ok(updt);
    }

    @DeleteMapping("/{id}")
    public void eliminarHabitacion(@PathVariable long id){
        habitacionService.delete(id);
    }
}
