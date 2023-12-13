package com.tutorpets.model.dto;

import com.tutorpets.model.Tutor;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class TutorDTOMapper implements Function<Tutor, TutorDTO> {
    @Override
    public TutorDTO apply(Tutor tutor) {
        return new TutorDTO(
                tutor.getId(),
                tutor.getName(),
                tutor.getNickName(),
                tutor.getBirthDate(),
                tutor.getPets()
                        .stream()
                        .map(pet -> new PetDTO(
                                pet.getId(),
                                pet.getName(),
                                pet.getPetBreed(),
                                pet.getBirthDate(),
                                pet.getColor(),
                                pet.getWeight(),
                                pet.getVaccineDate(),
                                pet.getVaccineType(),
                                pet.getTutor().getName()
                        )).toList());
    }
}
