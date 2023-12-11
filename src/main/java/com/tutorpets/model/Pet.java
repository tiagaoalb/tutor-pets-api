package com.tutorpets.model;

import com.fasterxml.jackson.annotation.JsonSetter;
import com.tutorpets.model.dto.PetDTO;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "pets")
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(name = "pet_breed")
    private String petBreed;
    @Column(name = "birth_date")
    private LocalDate birthDate;
    private String color;
    private Double weight;
    @Column(name = "vaccine_date")
    private LocalDate vaccineDate;
    @Column(name = "vaccine_type")
    private String vaccineType;

    @ManyToOne
    @JoinColumn(name = "tutor_id")
    private Tutor tutor;

    @Transient
    private Long tutorId;

    public Pet() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPetBreed() {
        return petBreed;
    }

    public void setPetBreed(String petBreed) {
        this.petBreed = petBreed;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public LocalDate getVaccineDate() {
        return vaccineDate;
    }

    public void setVaccineDate(LocalDate vaccineDate) {
        this.vaccineDate = vaccineDate;
    }

    public String getVaccineType() {
        return vaccineType;
    }

    public void setVaccineType(String vaccineType) {
        this.vaccineType = vaccineType;
    }

    public Long getTutorId() {
        return tutorId;
    }

    public void setTutorId(Long tutorId) {
        this.tutorId = tutorId;
    }

    @JsonSetter("tutor")
    public void setTutorById(Long tutorId) {
        this.tutor = new Tutor();
        this.tutor.setId(tutorId);
    }

    public PetDTO petDTO() {
        return new PetDTO(
                this.getId(),
                this.getName(),
                this.getPetBreed(),
                this.getBirthDate(),
                this.getColor(),
                this.getWeight(),
                this.getVaccineDate(),
                this.getVaccineType()
        );
    }
}
