package com.tutorpets.service;

import com.tutorpets.model.Tutor;
import com.tutorpets.repository.TutorRepository;
import com.tutorpets.service.exception.DataNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TutorService {

    private final TutorRepository tutorRepository;

    public TutorService(TutorRepository tutorRepository) {
        this.tutorRepository = tutorRepository;
    }

    public Tutor addTutor(Tutor tutor) {
        return tutorRepository.save(tutor);
    }

    public List<Tutor> findAllTutors() {
        return tutorRepository.findAll();
    }

    public Tutor findTutorById(Long id) {
        return tutorRepository.findById(id).orElseThrow(
                () -> new DataNotFoundException(HttpStatus.NOT_FOUND, "Tutor not found with id" + id)
        );
    }

    public List<Tutor> findTutorByName(String name) {
        return tutorRepository.findTutorByNameContainingIgnoreCase(name);
    }
}
