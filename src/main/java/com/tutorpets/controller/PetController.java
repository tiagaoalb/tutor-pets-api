package com.tutorpets.controller;

import com.tutorpets.model.Pet;
import com.tutorpets.service.PetService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pets")
public class PetController {

    private final PetService petService;

    public PetController(PetService petService) {
        this.petService = petService;
    }

    @PostMapping("/add")
    public ResponseEntity<Pet> addPet(@RequestBody Pet pet) {
        return new ResponseEntity<>(petService.addPet(pet), HttpStatus.CREATED);
    }

    @GetMapping("/find")
    public ResponseEntity<List<Pet>> findAllPets() {
        return new ResponseEntity<>(petService.findAllPets(), HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Pet> findPetById(@PathVariable Long id) {
        return new ResponseEntity<>(petService.findPetById(id), HttpStatus.OK);
    }

    @GetMapping("/find/name")
    public ResponseEntity<List<Pet>> findPetByName(@RequestParam String name) {
        return new ResponseEntity<>(petService.findPetByName(name), HttpStatus.OK);
    }
}
