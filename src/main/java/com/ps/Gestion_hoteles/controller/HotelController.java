package com.ps.Gestion_hoteles.controller;

import com.ps.Gestion_hoteles.model.Hotel;
import com.ps.Gestion_hoteles.service.HotelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hoteles")
@RequiredArgsConstructor

public class HotelController {
    private final HotelService hotelService;

    // Obtener hoteles
    @GetMapping("/all")
    public List<Hotel> obtenerHoteles(){
        List<Hotel> hoteles = hotelService.findAll();
        return hoteles;
    }

    // Obtener Hotel especifico
    @GetMapping("/{id}")
    public ResponseEntity<Hotel> obtenerHotel(@PathVariable long id){
        Hotel hotel = hotelService.findById(id).get();
        return ResponseEntity.ok(hotel);
    }

    // Crear Hotel
    @PostMapping
    public ResponseEntity<?> saveHotel(@RequestBody Hotel hotel){
        try {
            return ResponseEntity.ok(hotelService.save(hotel));
        }catch (RuntimeException event){
            return ResponseEntity.badRequest().body(event.getMessage());
        }
    }

    // Actualizar Hotel
    @PutMapping("/{id}")
    public ResponseEntity<Hotel> updateHotel(@PathVariable long id, @RequestBody Hotel hotel){
        if (id != hotel.getHotel_id()){
            return ResponseEntity.badRequest().build();
        }
        Hotel actualizado = hotelService.update(hotel);
        return ResponseEntity.ok(actualizado);
    }

    // Eliminar Hotel
    @DeleteMapping("/{id}")
    public void deleteHotel(@PathVariable long id){
        hotelService.delete(id);
    }
}
