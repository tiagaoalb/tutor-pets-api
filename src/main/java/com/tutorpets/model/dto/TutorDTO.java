package com.tutorpets.model.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.List;

public record TutorDTO (
        Long id,
        @NotNull
        @NotEmpty
        String name,
        @NotNull
        @NotEmpty
        String nickName,
        @NotNull
        @NotEmpty
        LocalDate birthDate,
        @NotNull
        @NotEmpty
        List<PetDTO> pets
) {
}
