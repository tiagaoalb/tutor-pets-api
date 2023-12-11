package com.tutorpets.controller;

import com.tutorpets.model.Tutor;
import com.tutorpets.service.TutorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tutors")
public class TutorController {

    private final TutorService tutorService;

    public TutorController(TutorService tutorService) {
        this.tutorService = tutorService;
    }

    @PostMapping("/add")
    public ResponseEntity<Tutor> addTutor(@RequestBody Tutor tutor) {
        return new ResponseEntity<>(tutorService.addTutor(tutor), HttpStatus.CREATED);
    }

    @GetMapping("/find")
    public ResponseEntity<List<Tutor>> findAllTutors() {
        return new ResponseEntity<>(tutorService.findAllTutors(), HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Tutor> findTutorById(@PathVariable Long id) {
        return new ResponseEntity<>(tutorService.findTutorById(id), HttpStatus.OK);
    }

    @GetMapping("/find/name")
    public ResponseEntity<List<Tutor>> findTutorByName(@RequestParam String name) {
        return new ResponseEntity<>(tutorService.findTutorByName(name), HttpStatus.OK);
    }
}
