package com.example.demo.repository

import Device
import org.springframework.data.jpa.repository.JpaRepository

interface DeviceRepository : JpaRepository<Device, Long> {
    // You can add custom query methods here if needed
}
