package com.tutorpets.model;

import jakarta.persistence.*;

import java.time.LocalDate;

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

    public Tutor() {
    }

    public Tutor(String name, String nickName, LocalDate birthDate) {
        this.name = name;
        this.nickName = nickName;
        this.birthDate = birthDate;
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
}
