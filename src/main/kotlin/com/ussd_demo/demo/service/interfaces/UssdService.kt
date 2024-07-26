package com.ussd_demo.demo.service.interfaces

interface UssdService {
    fun process(
        sessionId: String, phoneNumber: String, networkCode: String,
        serviceCode: String, text: String
    ): String
}