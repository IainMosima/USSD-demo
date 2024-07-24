package com.ussd_demo.demo.service

import com.ussd_demo.demo.data.session.USSDSession

interface SessionManager {
    fun createSession(
        sessionId: String, phoneNumber: String, networkCode: String,
        serviceCode: String, currentMenuItem: String
    ): USSDSession

    fun getSession(sessionId: String): USSDSession?

    fun clearSession(sessionId: String)
}