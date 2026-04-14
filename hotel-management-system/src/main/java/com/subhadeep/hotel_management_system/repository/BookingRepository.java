package com.subhadeep.hotel_management_system.repository;

import com.subhadeep.hotel_management_system.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {

    // Custom method
    List<Booking> findByUserId(Long userId);
}
