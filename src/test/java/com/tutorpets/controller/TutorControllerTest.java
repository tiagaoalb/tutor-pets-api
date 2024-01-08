package com.tutorpets.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tutorpets.dto.TutorDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(TutorController.class)
@AutoConfigureMockMvc
class TutorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void shouldAddTutor_ifPayloadIsCorrect() throws Exception {
        TutorDTO tutorDTO = new TutorDTO(
                1L, "Tiago", "Bovas", LocalDate.parse("2000-01-01"), null
        );

        mockMvc.perform(MockMvcRequestBuilders.post("/tutors/add")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(tutorDTO)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.name").value("Tiago"))
                .andExpect(jsonPath("$.nickName").value("Bovas"))
                .andExpect(jsonPath("$.birthDate").value("2000-01-01"))
                .andExpect(jsonPath(null));

        )

    }

    @Test
    void findAllTutors() {
    }

    @Test
    void findTutorById() {
    }

    @Test
    void findTutorByName() {
    }
}