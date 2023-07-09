package com.example.demo.controller

import com.example.demo.repository.DeviceRepository
import org.springframework.web.bind.annotation.*
import UserRepository
import Device

@RestController
@RequestMapping("/devices")
class DeviceController(
    private val deviceRepository: DeviceRepository,
    private val userRepository: UserRepository
) {

    @PostMapping
    fun createDevice(@RequestBody device: Device): Device {
        return deviceRepository.save(device)
    }

    @PutMapping("/{deviceId}/assign/{userId}")
    fun assignDeviceToUser(
        @PathVariable deviceId: Long,
        @PathVariable userId: Long
    ): Device? {
        val device = deviceRepository.findById(deviceId).orElse(null)
        val user = userRepository.findById(userId).orElse(null)

        if (device != null && user != null) {
            device.user = user
            return deviceRepository.save(device)
        }

        return null
    }

    @GetMapping
    fun getAllDevices(): List<Device> {
        return deviceRepository.findAll()
    }
}
