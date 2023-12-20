package com.tutorpets.model.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record PetDTO(
        Long id,
        @NotNull
        @NotEmpty
        String name,
        @NotNull
        @NotEmpty
        String petBreed,
        @NotNull
        @NotEmpty
        LocalDate birthDate,
        @NotNull
        @NotEmpty
        String color,
        @NotNull
        @NotEmpty
        Double weight,
        @NotNull
        @NotEmpty
        LocalDate vaccineDate,
        @NotNull
        @NotEmpty
        String vaccineType,
        @NotNull
        @NotEmpty
        String tutorName
) {
}
