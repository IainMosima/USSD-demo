package com.ussd_demo.demo.service.implementations

import com.ussd_demo.demo.data.session.USSDSession
import com.ussd_demo.demo.service.interfaces.SessionManager
import com.ussd_demo.demo.service.interfaces.UssdService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.cache.annotation.CacheEvict
import org.springframework.cache.annotation.CachePut
import org.springframework.cache.annotation.Cacheable
import org.springframework.stereotype.Service

@Service
class SessionManager : SessionManager {
    private val logger: Logger = LoggerFactory.getLogger(SessionManager::class.java)

//    @Cacheable(cacheNames = ["sessionCache"], key = "#sessionId")
    override fun createSession(
        sessionId: String,
        phoneNumber: String,
        networkCode: String,
        serviceCode: String,
        text: String,
    ): USSDSession {
        logger.info(
            "Creating a new session with sessionId: $sessionId"
        )
        val session = USSDSession(
            sessionId = sessionId,
            serviceCode = serviceCode,
            phoneNumber = phoneNumber,
            networkCode = networkCode,
            text = text
        )
        return session;
    }

    @Cacheable(cacheNames = ["sessionCache"], key = "#sessionId")
    override fun getSession(sessionId: String): USSDSession? {
        return null
    }

    @CachePut(cacheNames = ["sessionCache"], key = "#sessionId")
    override fun updateSession(
        sessionId: String,
        text: String
    ): USSDSession? {
        val existingSession = getSession(sessionId)
        return if (existingSession != null) {
            existingSession.text = text
            existingSession
        } else {
            null
        }
    }



    @CacheEvict(cacheNames = ["sessionCache"], key = "#sessionId")
    override fun clearSession(sessionId: String) {}
}