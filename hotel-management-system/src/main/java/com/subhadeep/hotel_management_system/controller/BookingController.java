package com.subhadeep.hotel_management_system.controller;
import com.subhadeep.hotel_management_system.dto.BookingRequestDTO;
import com.subhadeep.hotel_management_system.model.Booking;
import com.subhadeep.hotel_management_system.service.BookingService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping
    public Booking createBooking(@Valid @RequestBody BookingRequestDTO dto) {

        Booking booking = new Booking();
        booking.setCheckIn(dto.getCheckIn());
        booking.setCheckOut(dto.getCheckOut());

        return bookingService.createBookingFromDTO(dto);
    }
    @GetMapping("/{id}")
    public Booking getBooking(@PathVariable Long id) {
        return bookingService.getBookingById(id);
    }

    @GetMapping("/user/{userId}")
    public List<Booking> getBookingsByUser(@PathVariable Long userId) {
        return bookingService.getBookingsByUserId(userId);
    }

    @DeleteMapping("/{id}")
    public String deleteBooking(@PathVariable Long id) {
        bookingService.deleteBooking(id);
        return "Booking deleted successfully";
    }
}