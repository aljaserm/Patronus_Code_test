package com.example.demo.controller


import org.springframework.web.bind.annotation.*
import User
import UserRepository

@RestController
@RequestMapping("/users")
class UserController(private val userRepository: UserRepository) {

    @PostMapping
    fun createUser(@RequestBody user: User): User {
        return userRepository.save(user)
    }

    @GetMapping
    fun getAllUsers(): List<User> {
        return userRepository.findAll()
    }

    @GetMapping("/with-devices")
    fun getAllUsersWithDevices(): List<User> {
        return userRepository.findAllByDevicesIsNotEmpty()
    }
}
