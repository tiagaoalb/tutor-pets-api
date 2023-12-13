package com.tutorpets.model.dto;

import com.tutorpets.model.Pet;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class PetDTOMapper implements Function<Pet, PetDTO> {
    @Override
    public PetDTO apply(Pet pet) {
        return new PetDTO(
                pet.getId(),
                pet.getName(),
                pet.getPetBreed(),
                pet.getBirthDate(),
                pet.getColor(),
                pet.getWeight(),
                pet.getVaccineDate(),
                pet.getVaccineType(),
                pet.getTutor().getName()
        );
    }
}
