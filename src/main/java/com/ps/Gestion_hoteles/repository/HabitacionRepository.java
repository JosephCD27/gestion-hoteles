package com.ps.Gestion_hoteles.repository;

import com.ps.Gestion_hoteles.model.Habitacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface HabitacionRepository extends JpaRepository<Habitacion, Long> {

    @Query("SELECT COUNT(h) FROM Habitacion h WHERE h.hotel.hotel_id = :hotelId AND h.habitacion_piso = :piso")
    int countByHotelAndPiso(@Param("hotelId") Long hotelId, @Param("piso") int piso);
}
