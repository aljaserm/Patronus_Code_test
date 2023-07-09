package com.example.demo.service

import com.example.demo.repository.DeviceRepository

import org.springframework.stereotype.Service
import UserRepository
import Device

@Service
class DeviceService(
    private val deviceRepository: DeviceRepository,
    private val userRepository: UserRepository
) {

    fun createDevice(device: Device): Device {
        return deviceRepository.save(device)
    }

    fun assignDeviceToUser(deviceId: Long, userId: Long): Device? {
        val device = deviceRepository.findById(deviceId).orElse(null)
        val user = userRepository.findById(userId).orElse(null)

        if (device != null && user != null) {
            device.user = user
            return deviceRepository.save(device)
        }

        return null
    }

    fun getAllDevices(): List<Device> {
        return deviceRepository.findAll()
    }
}
