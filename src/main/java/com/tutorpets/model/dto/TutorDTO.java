package com.tutorpets.model.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;

import java.time.LocalDate;
import java.util.List;

public record TutorDTO (
        @Valid
        Long id,
        @NotNull(message = "name is mandatory")
        @NotBlank(message = "name is mandatory")
        String name,
        @NotNull(message = "nickName is mandatory")
        @NotBlank(message = "nickName is mandatory")
        String nickName,
        @NotNull(message = "birthDate is mandatory")
        @Past
        LocalDate birthDate,
        List<PetDTO> pets
) {
}
