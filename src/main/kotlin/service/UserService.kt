package com.example.demo.service

import User
import UserRepository
import Device
import org.springframework.stereotype.Service
import com.example.demo.repository.DeviceRepository

@Service
class UserService(
    private val userRepository: UserRepository,
    private val deviceRepository: DeviceRepository
) {

    fun createUser(user: User): User {
        return userRepository.save(user)
    }

    fun assignDeviceToUser(userId: Long, deviceId: Long): User? {
        val user = userRepository.findById(userId).orElse(null)
        val device = deviceRepository.findById(deviceId).orElse(null)

        if (user != null && device != null) {
            user.devices.add(device)
            return userRepository.save(user)
        }

        return null
    }

    fun getAllUsersWithDevices(): List<User> {
        return userRepository.findAllByDevicesIsNotEmpty()
    }
}
