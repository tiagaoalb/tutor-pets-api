package com.tutorpets.dto;

import com.tutorpets.annotation.NoNumbers;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

import java.math.BigDecimal;
import java.time.LocalDate;

public record PetDTO(
        @Valid
        Long id,
        @NotNull(message = "name is mandatory")
        @NotBlank(message = "name is mandatory")
        @NoNumbers(message = "The field name must not contain numerical characters")
        String name,
        @NotNull(message = "petBreed is mandatory")
        @NotBlank(message = "petBreed is mandatory")
        @NoNumbers(message = "The field petBreed must not contain numerical characters")
        String petBreed,
        @NotNull(message = "birthDate is mandatory")
        @Past
        LocalDate birthDate,
        @NotNull(message = "color is mandatory")
        @NotBlank(message = "color is mandatory")
        @NoNumbers(message = "The field color must not contain numerical characters")
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
        @NoNumbers(message = "The field vaccineType must not contain numerical characters")
        String vaccineType,
        @NotNull(message = "tutorName is mandatory")
        @NotBlank(message = "tutorName is mandatory")
        @NoNumbers(message = "The field tutorName must not contain numerical characters")
        String tutorName
) {
}
