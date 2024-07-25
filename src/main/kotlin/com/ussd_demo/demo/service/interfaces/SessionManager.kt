package com.ussd_demo.demo.service.interfaces

import com.ussd_demo.demo.data.session.USSDSession

interface SessionManager {
    fun createSession(
        sessionId: String, phoneNumber: String, networkCode: String,
        serviceCode: String, text: String
    ): USSDSession

    fun getSession(sessionId: String): USSDSession?

    fun updateSession(session: USSDSession)

    fun clearSession(sessionId: String)
}