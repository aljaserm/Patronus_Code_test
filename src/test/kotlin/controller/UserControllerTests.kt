package com.example.demo.controller

import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations.initMocks
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*
import java.util.*
import UserRepository
import User
import java.time.LocalDate

@WebMvcTest(UserController::class)
@AutoConfigureMockMvc
class UserControllerTests {
    @Autowired
    private lateinit var mockMvc: MockMvc

    @Autowired
    private lateinit var objectMapper: ObjectMapper

    @Mock
    private lateinit var userRepository: UserRepository

    @BeforeEach
    fun setUp() {
        initMocks(this)
    }

    @Test
    fun createUser() {
        val user = User(1L, "John", "Doe", "123 Street", LocalDate.now())

        `when`(userRepository.save(user)).thenReturn(user)

        mockMvc.perform(
            post("/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(user))
        )
            .andExpect(status().isOk)
            .andExpect(content().json(objectMapper.writeValueAsString(user)))
    }

    @Test
    fun getAllUsers() {
        val users = listOf(
            User(1L, "John", "Doe", "123 Street", LocalDate.now()),
            User(2L, "Jane", "Smith", "456 Avenue", LocalDate.now())
        )

        `when`(userRepository.findAll()).thenReturn(users)

        mockMvc.perform(
            get("/users")
        )
            .andExpect(status().isOk)
            .andExpect(content().json(objectMapper.writeValueAsString(users)))
    }
}
