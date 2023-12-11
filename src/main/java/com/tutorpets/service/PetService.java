package com.tutorpets.service;

import com.tutorpets.model.Pet;
import com.tutorpets.repository.PetRepository;
import com.tutorpets.service.exception.DataNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetService {

    private final PetRepository petRepository;

    public PetService(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    public Pet addPet(Pet pet) {
        return petRepository.save(pet);
    }

    public List<Pet> findAllPets() {
        return petRepository.findAll();
    }

    public Pet findPetById(Long id) {
        return petRepository.findById(id).orElseThrow(
                () -> new DataNotFoundException(HttpStatus.NOT_FOUND, "Pet not found with id" + id)
        );
    }

    public List<Pet> findPetByName(String name) {
        return petRepository.findPetByNameContainingIgnoreCase(name);
    }
}
