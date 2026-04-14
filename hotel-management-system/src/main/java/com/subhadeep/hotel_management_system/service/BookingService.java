package com.subhadeep.hotel_management_system.service;

import com.subhadeep.hotel_management_system.dto.BookingRequestDTO;
import com.subhadeep.hotel_management_system.exception.ResourceNotFoundException;
import com.subhadeep.hotel_management_system.model.Booking;
import com.subhadeep.hotel_management_system.model.Room;
import com.subhadeep.hotel_management_system.model.User;
import com.subhadeep.hotel_management_system.repository.BookingRepository;
import com.subhadeep.hotel_management_system.repository.RoomRepository;
import com.subhadeep.hotel_management_system.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoomRepository roomRepository;

    public Booking createBooking(Booking booking) {

        // 🔥 IMPORTANT CHECKS
        if (booking.getUser() == null || booking.getRoom() == null) {
            throw new RuntimeException("User or Room cannot be null");
        }

        Long userId = booking.getUser().getId();
        Long roomId = booking.getRoom().getId();

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Room room = roomRepository.findById(roomId)
                .orElseThrow(() -> new RuntimeException("Room not found"));

        booking.setUser(user);
        booking.setRoom(room);

        return bookingRepository.save(booking);
    }

    public Booking getBookingById(Long id) {
        return bookingRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Booking not found with id: " + id));
    }

    public List<Booking> getBookingsByUserId(Long userId) {
        return bookingRepository.findByUserId(userId);
    }

    public void deleteBooking(Long id) {
        bookingRepository.deleteById(id);
    }
    public Booking createBookingFromDTO(BookingRequestDTO dto) {

        // 🔥 DATE VALIDATION
        if (dto.getCheckOut().isBefore(dto.getCheckIn())) {
            throw new RuntimeException("Check-out date must be after check-in date");
        }

        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Room room = roomRepository.findById(dto.getRoomId())
                .orElseThrow(() -> new RuntimeException("Room not found"));

        Booking booking = new Booking();
        booking.setCheckIn(dto.getCheckIn());
        booking.setCheckOut(dto.getCheckOut());
        booking.setUser(user);
        booking.setRoom(room);

        return bookingRepository.save(booking);
    }
}