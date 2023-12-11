package com.tutorpets.model.dto;

import java.time.LocalDate;

public record PetDTO(
        Long id,
        String name,
        String petBreed,
        LocalDate birthDate,
        String color,
        Double weight,
        LocalDate vaccineDate,
        String vaccineType
) {
}
