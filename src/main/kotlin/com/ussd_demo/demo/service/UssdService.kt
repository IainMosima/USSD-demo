package com.ussd_demo.demo.service

interface UssdService {
    suspend fun process(
        sessionId: String, phoneNumber: String, networkCode: String,
        serviceCode: String, currentMenuItem: String
    ): String
}