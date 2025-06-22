package com.ps.Gestion_hoteles.service;

import com.ps.Gestion_hoteles.model.Hotel;
import com.ps.Gestion_hoteles.repository.HotelRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class HotelService {
    private HotelRepository hotelRepository;

    // obtener hoteles
    public List<Hotel> findAll(){
        List<Hotel> hoteles = hotelRepository.findAll();
        return hoteles;
    }

    //obtener hotel especifico
    public Optional<Hotel> findById(long id){
        return hotelRepository.findById(id);
    }

    // registrar hotel
    public Hotel save(Hotel hotel) throws RuntimeException{
        if (hotel.getHotel_nombre() == null){
            throw new RuntimeException("El nombre del hotel es obligatorio");
        }

        if (hotel.getHotel_ciudad()== null){
            throw new RuntimeException("La ciudad del hotel es obligatorio");
        }

        if (hotel.getHotel_direccion() == null){
            throw new RuntimeException("La direccion del hotel es obligatorio");
        }
        return hotelRepository.save(hotel);
    }

    public Hotel update(Hotel hotel){
        return hotelRepository.save(hotel);
    }

    public void delete(long id){
        var hotel = findById(id).get();

        if (hotel != null){
            hotelRepository.delete(hotel);
        }
    }
}
