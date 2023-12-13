package com.tutorpets.service;

import com.tutorpets.model.Pet;
import com.tutorpets.model.Tutor;
import com.tutorpets.model.dto.PetDTO;
import com.tutorpets.model.dto.PetDTOMapper;
import com.tutorpets.repository.PetRepository;
import com.tutorpets.repository.TutorRepository;
import com.tutorpets.service.exception.DataNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetService {

    private final PetRepository petRepository;
    private final TutorRepository tutorRepository;
    private final PetDTOMapper petDTOMapper;

    public PetService(PetRepository petRepository, TutorRepository tutorRepository, PetDTOMapper petDTOMapper) {
        this.petRepository = petRepository;
        this.tutorRepository = tutorRepository;
        this.petDTOMapper = petDTOMapper;
    }

    public PetDTO addPet(PetDTO petDTO) {
        Pet pet = new Pet();
        pet.setName(petDTO.name());
        pet.setPetBreed(petDTO.petBreed());
        pet.setBirthDate(petDTO.birthDate());
        pet.setColor(petDTO.color());
        pet.setWeight(petDTO.weight());
        pet.setVaccineDate(petDTO.vaccineDate());
        pet.setVaccineType(petDTO.vaccineType());

        Tutor tutor = tutorRepository.findTutorByName(petDTO.tutorName());

        pet.setTutor(tutor);

        pet = petRepository.save(pet);

        return petDTOMapper.apply(pet);
    }

    public List<PetDTO> findAllPets() {
        return petRepository.findAll()
                .stream()
                .map(petDTOMapper).toList();
    }

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
