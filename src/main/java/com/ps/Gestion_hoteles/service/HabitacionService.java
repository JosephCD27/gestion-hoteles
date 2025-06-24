package com.ps.Gestion_hoteles.service;

import com.ps.Gestion_hoteles.model.Habitacion;
import com.ps.Gestion_hoteles.repository.HabitacionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class HabitacionService {
    private HabitacionRepository habitacionRepository;

    public List<Habitacion> findAll(){
        List<Habitacion> habitaciones = habitacionRepository.findAll();
        return habitaciones;
    }

    public Optional<Habitacion> findById(long id){
        return habitacionRepository.findById(id);
    }

    public Habitacion save(Habitacion habitacion) throws RuntimeException {
        try {
            Long hotelId = habitacion.getHotel().getHotel_id();
            int piso = habitacion.getHabitacion_piso();

            if (habitacion.getHabitacion_piso() <= 0) {
                throw new RuntimeException("El piso de la habitación es obligatorio y debe ser mayor a 0");
            }

            if (habitacion.getHabitacion_capacidad() <= 0) {
                throw new RuntimeException("La capacidad de la habitación es obligatoria y debe ser mayor a 0");
            }

            if (habitacion.getHotel() == null) {
                throw new RuntimeException("El hotel asociado a la habitación es obligatorio");
            }

            if (habitacion.getTipoHabitacion() == null) {
                throw new RuntimeException("El tipo de habitación es obligatorio");
            }

            if (habitacion.getEstadoHabitacion() == null) {
                throw new RuntimeException("El estado de la habitación es obligatorio");
            }

            int totalEnPiso = habitacionRepository.countByHotelAndPiso(hotelId, piso);

            int numero = totalEnPiso + 1;

            String consecutivo = String.format("h%d-%d%02d", hotelId, piso, numero);
            habitacion.setHabitacion_consecutivo(consecutivo);

            return habitacionRepository.save(habitacion);

        } catch (RuntimeException e) {
            throw new RuntimeException("Error al guardar la habitación: " + e.getMessage());
        }
    }

    public Habitacion update(Habitacion habitacion){
        return habitacionRepository.save(habitacion);
    }

    public void delete(long id){
        var habitacion = findById(id).get();

        if (habitacion != null){
            habitacionRepository.delete(habitacion);
        }
    }
}
