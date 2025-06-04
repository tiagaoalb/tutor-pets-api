package com.tutorpets.dto;

import com.tutorpets.annotation.NoNumbers;
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
        @NoNumbers(message = "The field name must not contain numerical characters")
        String name,
        @NotNull(message = "nickName is mandatory")
        @NotBlank(message = "nickName is mandatory")
        @NoNumbers(message = "The field nickName must not contain numerical characters")
        String nickName,
        @NotNull(message = "birthDate is mandatory")
        @Past
        LocalDate birthDate,
        List<PetDTO> pets
        // test
) {
}
