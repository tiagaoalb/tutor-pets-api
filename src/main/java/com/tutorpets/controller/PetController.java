package com.tutorpets.controller;

import com.tutorpets.dto.PetDTO;
import com.tutorpets.service.PetService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pets")
public class PetController {

    private final PetService petService;

    public PetController(PetService petService) {
        this.petService = petService;
    }

    @PostMapping("/add")
    public ResponseEntity<PetDTO> addPet(@Valid @RequestBody PetDTO petDTO) {
        return new ResponseEntity<>(petService.addPet(petDTO), HttpStatus.CREATED);
    }

    @GetMapping("/find")
    public ResponseEntity<List<PetDTO>> findAllPets() {
        return new ResponseEntity<>(petService.findAllPets(), HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Optional<PetDTO>> findPetById(@PathVariable Long id) {
        return new ResponseEntity<>(petService.findPetById(id), HttpStatus.OK);
    }

    @GetMapping("/find/name")
    public ResponseEntity<List<PetDTO>> findPetByName(@RequestParam String name) {
        return new ResponseEntity<>(petService.findPetByName(name), HttpStatus.OK);
    }

    @PatchMapping("/update/{id}/newName")
    public ResponseEntity<Void> updatePetNameById(@PathVariable Long id, @RequestParam String newName) {
        petService.updatePetNameById(id, newName);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deletePetById(@PathVariable Long id) {
        petService.deletePetById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
