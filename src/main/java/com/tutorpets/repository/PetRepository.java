package com.tutorpets.repository;

import com.tutorpets.model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PetRepository extends JpaRepository<Pet, Long> {

    @Query("""
            select p
            from Pet p
            left join fetch p.tutor
            where lower(p.name) like lower(concat('%', :name, '%'))
            """)
    List<Pet> findPetByNameContainingIgnoreCase(String name);

    @Query("""
            select p
            from Pet p
            left join fetch p.tutor
            """)
    List<Pet> findAllPets();

    @Query("""
            select p
            from Pet p
            left join fetch p.tutor
            where p.id = :petId
            """)
    Pet findPetById(@Param("petId") Long petId);
}
