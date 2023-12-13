package com.tutorpets.controller;

import com.tutorpets.model.dto.PetDTO;
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
    public ResponseEntity<PetDTO> addPet(@RequestBody PetDTO petDTO) {
        return new ResponseEntity<>(petService.addPet(petDTO), HttpStatus.CREATED);
    }

    @GetMapping("/find")
    public ResponseEntity<List<PetDTO>> findAllPets() {
        return new ResponseEntity<>(petService.findAllPets(), HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<PetDTO> findPetById(@PathVariable Long id) {
        return new ResponseEntity<>(petService.findPetById(id), HttpStatus.OK);
    }

    @GetMapping("/find/name")
    public ResponseEntity<List<PetDTO>> findPetByName(@RequestParam String name) {
        return new ResponseEntity<>(petService.findPetByName(name), HttpStatus.OK);
    }
}
