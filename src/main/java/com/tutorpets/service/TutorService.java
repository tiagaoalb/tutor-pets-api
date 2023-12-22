package com.tutorpets.service;

import com.tutorpets.model.Tutor;
import com.tutorpets.dto.TutorDTO;
import com.tutorpets.dto.TutorDTOMapper;
import com.tutorpets.repository.TutorRepository;
import com.tutorpets.service.exception.DataNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TutorService {

    private final TutorRepository tutorRepository;
    private final TutorDTOMapper tutorDTOMapper;

    public TutorService(TutorRepository tutorRepository, TutorDTOMapper tutorDTOMapper) {
        this.tutorRepository = tutorRepository;
        this.tutorDTOMapper = tutorDTOMapper;
    }

    public TutorDTO addTutor(TutorDTO tutorDTO) {
        var tutorName = tutorDTO.name();
        if (tutorRepository.existsByName(tutorName)) {
            throw new DataNotFoundException(HttpStatus.CONFLICT, "Tutor with name " + tutorName + " already exists.");
        }

        Tutor tutor = new Tutor();
        tutor.setName(tutorDTO.name());
        tutor.setNickName(tutorDTO.nickName());
        tutor.setBirthDate(tutorDTO.birthDate());

        tutor = tutorRepository.save(tutor);
        return tutorDTOMapper.apply(tutor);
    }

    public List<TutorDTO> findAllTutors() {
        return tutorRepository.findAllTutors()
                .stream()
                .map(tutorDTOMapper).toList();
    }

    public Optional<TutorDTO> findTutorById(Long id) {
        Optional<Tutor> tutorOptional = Optional.ofNullable(tutorRepository.findTutorById(id));
        return Optional.ofNullable(tutorOptional.map(tutorDTOMapper)
                .orElseThrow(
                        () -> new DataNotFoundException(HttpStatus.NOT_FOUND, "Pet not found with id" + id)));
    }

    public List<TutorDTO> findTutorByName(String name) {
        var tutors = tutorRepository.findTutorByNameContainingIgnoreCase(name);
        if (tutors.isEmpty()) {
            throw new DataNotFoundException(HttpStatus.NOT_FOUND, "Tutor with name " + name + " was not found.");
        }
        return tutors.stream().map(tutorDTOMapper).toList();
    }
}
