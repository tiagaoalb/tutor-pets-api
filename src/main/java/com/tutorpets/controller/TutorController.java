package com.tutorpets.controller;

import com.tutorpets.dto.TutorDTO;
import com.tutorpets.service.TutorService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tutors")
public class TutorController {

    private final TutorService tutorService;

    public TutorController(TutorService tutorService) {
        this.tutorService = tutorService;
    }

    @PostMapping("/add")
    public ResponseEntity<TutorDTO> addTutor(@Valid @RequestBody TutorDTO tutorDTO) {
        return new ResponseEntity<>(tutorService.addTutor(tutorDTO), HttpStatus.CREATED);
    }

    @GetMapping("/find")
    public ResponseEntity<List<TutorDTO>> findAllTutors() {
        return new ResponseEntity<>(tutorService.findAllTutors(), HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Optional<TutorDTO>> findTutorById(@PathVariable Long id) {
        return new ResponseEntity<>(tutorService.findTutorById(id), HttpStatus.OK);
    }

    @GetMapping("/find/name")
    public ResponseEntity<List<TutorDTO>> findTutorByName(@RequestParam String name) {
        return new ResponseEntity<>(tutorService.findTutorByName(name), HttpStatus.OK);
    }
}
