package com.subhadeep.hotel_management_system.dto;

import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookingRequestDTO {

    @NotNull(message = "Check-in date required")
    private LocalDate checkIn;

    @NotNull(message = "Check-out date required")
    private LocalDate checkOut;

    @NotNull(message = "User ID required")
    private Long userId;

    @NotNull(message = "Room ID required")
    private Long roomId;
}