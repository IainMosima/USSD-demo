package com.ussd_demo.demo.service.implementations

import com.ussd_demo.demo.data.session.USSDSession
import com.ussd_demo.demo.service.interfaces.SessionManager
import org.springframework.cache.annotation.CacheEvict
import org.springframework.cache.annotation.Cacheable
import org.springframework.stereotype.Service

@Service
class SessionManager : SessionManager {

    @Cacheable(cacheNames = ["sessionCache"], key = "#sessionId")
    override fun createSession(
        sessionId: String,
        phoneNumber: String,
        networkCode: String,
        serviceCode: String,
        currentMenuItem: String,
    ): USSDSession {
        val session = USSDSession(
            sessionId = sessionId,
            serviceCode = serviceCode,
            phoneNumber = phoneNumber,
            networkCode = networkCode,
            currentMenuItem = currentMenuItem
        )
        return session;
    }

    @Cacheable(cacheNames = ["sessionCache"], key = "#sessionId")
    override fun getSession(sessionId: String): USSDSession? {
        return null
    }

    @CacheEvict(cacheNames = ["sessionCache"], key = "#sessionId")
    override fun clearSession(sessionId: String) {}
}