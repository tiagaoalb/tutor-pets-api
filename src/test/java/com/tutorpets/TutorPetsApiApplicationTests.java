package com.tutorpets;

import com.tutorpets.controller.PetController;
import com.tutorpets.controller.TutorController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class TutorPetsApiApplicationTests {

	@Autowired
	private TutorController tutorController;
	@Autowired
	private PetController petController;

	@Test
	void contextLoads()throws Exception {
		assertThat(tutorController).isNotNull();
		assertThat(petController).isNotNull();
	}
}
