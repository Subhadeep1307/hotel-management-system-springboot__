package com.subhadeep.hotel_management_system.repository;

import com.subhadeep.hotel_management_system.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoomRepository extends JpaRepository<Room, Long> {

    // Custom method
    List<Room> findByHotelId(Long hotelId);
}