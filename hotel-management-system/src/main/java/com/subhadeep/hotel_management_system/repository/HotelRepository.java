package com.subhadeep.hotel_management_system.repository;



import com.subhadeep.hotel_management_system.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Hotel, Long> {
}
