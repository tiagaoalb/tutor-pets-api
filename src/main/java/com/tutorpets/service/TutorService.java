package com.tutorpets.service;

import com.tutorpets.model.Tutor;
import com.tutorpets.model.dto.TutorDTO;
import com.tutorpets.model.dto.TutorDTOMapper;
import com.tutorpets.repository.TutorRepository;
import com.tutorpets.service.exception.DataNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TutorService {

    private final TutorRepository tutorRepository;
    private final TutorDTOMapper tutorDTOMapper;

    public TutorService(TutorRepository tutorRepository, TutorDTOMapper tutorDTOMapper) {
        this.tutorRepository = tutorRepository;
        this.tutorDTOMapper = tutorDTOMapper;
    }

    public Tutor addTutor(Tutor tutor) {
        return tutorRepository.save(tutor);
    }

    @Transactional
    public List<TutorDTO> findAllTutors() {
        return tutorRepository.findAll()
                .stream()
                .map(tutorDTOMapper).toList();
    }

    @Transactional
    public TutorDTO findTutorById(Long id) {
        return tutorRepository.findById(id)
                .map(tutorDTOMapper)
                .orElseThrow(
                () -> new DataNotFoundException(HttpStatus.NOT_FOUND, "Tutor not found with id" + id)
        );
    }

    public List<TutorDTO> findTutorByName(String name) {
        return tutorRepository.findTutorByNameContainingIgnoreCase(name)
                .stream()
                .map(tutorDTOMapper).toList();
    }
}
