package com.tutorpets.service;

import com.tutorpets.model.Pet;
import com.tutorpets.model.dto.PetDTO;
import com.tutorpets.model.dto.PetDTOMapper;
import com.tutorpets.repository.PetRepository;
import com.tutorpets.service.exception.DataNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PetService {

    private final PetRepository petRepository;
    private final PetDTOMapper petDTOMapper;

    public PetService(PetRepository petRepository, PetDTOMapper petDTOMapper) {
        this.petRepository = petRepository;
        this.petDTOMapper = petDTOMapper;
    }

    public Pet addPet(Pet pet) {
        return petRepository.save(pet);
    }

    @Transactional
    public List<PetDTO> findAllPets() {
        return petRepository.findAll()
                .stream()
                .map(petDTOMapper).toList();
    }

    @Transactional
    public PetDTO findPetById(Long id) {
        return petRepository.findById(id)
                .map(petDTOMapper)
                .orElseThrow(
                () -> new DataNotFoundException(HttpStatus.NOT_FOUND, "Pet not found with id" + id)
        );
    }

    public List<PetDTO> findPetByName(String name) {
        return petRepository.findPetByNameContainingIgnoreCase(name)
                .stream()
                .map(petDTOMapper).toList();
    }
}