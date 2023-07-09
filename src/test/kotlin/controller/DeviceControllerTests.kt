package com.example.demo.controller

import com.example.demo.repository.DeviceRepository
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
import Device

@WebMvcTest(DeviceController::class)
@AutoConfigureMockMvc
class DeviceControllerTests {
    @Autowired
    private lateinit var mockMvc: MockMvc

    @Autowired
    private lateinit var objectMapper: ObjectMapper

    @Mock
    private lateinit var deviceRepository: DeviceRepository

    @BeforeEach
    fun setUp() {
        initMocks(this)
    }

    @Test
    fun createDevice() {
        val device = Device(1L, "ABC123", "UUID123", "1234567890", "Model123")

        `when`(deviceRepository.save(device)).thenReturn(device)

        mockMvc.perform(
            post("/devices")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(device))
        )
            .andExpect(status().isOk)
            .andExpect(content().json(objectMapper.writeValueAsString(device)))
    }

    @Test
    fun getAllDevices() {
        val devices = listOf(
            Device(1L, "ABC123", "UUID123", "1234567890", "Model123"),
            Device(2L, "DEF456", "UUID456", "9876543210", "Model456")
        )

        `when`(deviceRepository.findAll()).thenReturn(devices)

        mockMvc.perform(
            get("/devices")
        )
            .andExpect(status().isOk)
            .andExpect(content().json(objectMapper.writeValueAsString(devices)))
    }
}
