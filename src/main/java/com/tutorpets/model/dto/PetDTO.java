package com.tutorpets.model.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

import java.math.BigDecimal;
import java.time.LocalDate;

public record PetDTO(
        @Valid
        Long id,
        @NotNull(message = "name is mandatory")
        @NotBlank(message = "name is mandatory")
        String name,
        @NotNull(message = "petBreed is mandatory")
        @NotBlank(message = "petBreed is mandatory")
        String petBreed,
        @NotNull(message = "birthDate is mandatory")
        @Past
        LocalDate birthDate,
        @NotNull(message = "color is mandatory")
        @NotBlank(message = "color is mandatory")
        String color,
        @NotNull(message = "weight is mandatory")
        @DecimalMin("0.1")
        @DecimalMax("1000.0")
        BigDecimal weight,
        @NotNull(message = "vaccineDate is mandatory")
        @Past
        LocalDate vaccineDate,
        @NotNull(message = "vaccineType is mandatory")
        @NotBlank(message = "vaccineType is mandatory")
        String vaccineType,
        @NotNull(message = "tutorName is mandatory")
        @NotBlank(message = "tutorName is mandatory")
        String tutorName
) {
}
