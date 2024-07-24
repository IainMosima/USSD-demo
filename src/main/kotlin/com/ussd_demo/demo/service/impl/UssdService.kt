package com.ussd_demo.demo.service.impl

import com.ussd_demo.demo.data.session.USSDSession
import com.ussd_demo.demo.service.SessionManager
import com.ussd_demo.demo.utils.AppFunctions.phoneNumberWithoutPlus
import com.ussd_demo.demo.service.UssdService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UssdService : UssdService {
    private val logger: Logger = LoggerFactory.getLogger(UssdService::class.java)

    @Autowired
    lateinit var sessionManager: SessionManager

    override suspend fun process(
        sessionId: String, phoneNumber: String, networkCode: String, serviceCode: String, currentMenuItem: String
    ): String {
        val cellNumber = phoneNumberWithoutPlus(phoneNumber)
        var session = sessionManager.getSession(sessionId)
        if (session == null) {
            logger.info(
                "Createing a new session with sessionId: $sessionId, " + "serviceCode: $serviceCode, networkCode: $networkCode, " + "cellNumber: $cellNumber , text: $currentMenuItem"

            )
            session = sessionManager.createSession(
                sessionId = sessionId,
                phoneNumber = cellNumber,
                networkCode = networkCode,
                serviceCode = serviceCode,
                currentMenuItem = currentMenuItem
            )
        }

        // More Logic handling here

        return processResults(session, currentMenuItem)
    }


    private suspend fun processResults(session: USSDSession, currentMenuItem: String): String {
        TODO("Not yet implemented")
    }

}