package com.day11.unittestingspring;

import com.day11.unittestingspring.model.Student;
import com.day11.unittestingspring.repository.StudentRepositiry;
import com.day11.unittestingspring.service.StudentService;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.util.List;

@SpringBootTest
@AutoConfigureMockMvc
class UnitTestingSpringApplicationTests extends AbstractContainerBaseTest{

	//test container to image docker @Testcontainers
	//@Container
	//private static PostgreSQLContainer postgreSQLContainer = new PostgreSQLContainer("postgres:latest");

	@Autowired
	private StudentService studentService;

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void givenStudents_whenGetAllStudents_thenListAll() throws Exception {
		//given
		List<Student> students =
				List.of(
						Student.builder().firstName("alfika").lastName("muis").email("alfika@gmail.com").build(),
						Student.builder().firstName("fandi").lastName("aditya").email("fandi@gmail.com").build(),
						Student.builder().firstName("fahmi").lastName("anurdin").email("fahmi@gmail.com").build()
						);
		studentService.createStudent(students);
		//when
		ResultActions response = mockMvc.perform(MockMvcRequestBuilders.get("/api/students"));
		//then
		response.andExpect(MockMvcResultMatchers.status().isOk());
		response.andExpect(MockMvcResultMatchers.jsonPath("$.size()", CoreMatchers.is(students.size())));
	}

	@Test
	public void givenStudentId_whenGetStudentDetails_thenList() throws Exception {
		//given
		List<Student> students =
				List.of(
						Student.builder().firstName("alfika").lastName("muis").email("alfika@gmail.com").build(),
						Student.builder().firstName("fandi").lastName("aditya").email("fandi@gmail.com").build(),
						Student.builder().firstName("fahmi").lastName("anurdin").email("fahmi@gmail.com").build()
				);
		studentService.createStudent(students);
		//when
		ResultActions response = mockMvc.perform(MockMvcRequestBuilders.get("/api/students/2"));
		//then
		response.andExpect(MockMvcResultMatchers.status().isOk());
		response.andExpect(MockMvcResultMatchers.jsonPath("$",CoreMatchers.is(students.get(2))));
	}

}
