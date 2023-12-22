package com.tutorpets.dto;

import com.tutorpets.model.Tutor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;
import java.util.function.Function;

@Service
public class TutorDTOMapper implements Function<Tutor, TutorDTO> {

    private final PetDTOMapper petDTOMapper;

    public TutorDTOMapper(PetDTOMapper petDTOMapper) {
        this.petDTOMapper = petDTOMapper;
    }

    @Override
    public TutorDTO apply(Tutor tutor) {
        return new TutorDTO(
                tutor.getId(),
                tutor.getName(),
                tutor.getNickName(),
                tutor.getBirthDate(),
                Optional.ofNullable(tutor.getPets())
                        .orElse(Collections.emptyList())
                        .stream()
                        .map(petDTOMapper)
                        .toList());
    }
}
