package com.tutorpets.model;

import com.tutorpets.model.dto.TutorDTO;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "tutors")
public class Tutor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(name = "nick_name")
    private String nickName;
    @Column(name = "birth_date")
    private LocalDate birthDate;

    @OneToMany(mappedBy = "tutor", cascade = CascadeType.ALL)
    private List<Pet> pets;

    public Tutor() {
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

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public TutorDTO toDTO() {
        return new TutorDTO(
                this.getId(),
                this.getName(),
                this.getNickName(),
                this.getBirthDate(),
                this.pets != null ? this.pets.stream().map(Pet::petDTO).toList() : null
        );
    }

}
