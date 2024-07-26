package com.ussd_demo.demo.service.implementations

import com.ussd_demo.demo.data.session.USSDSession
import com.ussd_demo.demo.enum.MENU
import com.ussd_demo.demo.enum.RENTSTATUS
import com.ussd_demo.demo.service.interfaces.SessionManager
import com.ussd_demo.demo.utils.AppFunctions.phoneNumberWithoutPlus
import com.ussd_demo.demo.service.interfaces.UssdService
import com.ussd_demo.demo.utils.AppFunctions
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UssdService : UssdService {
    private val logger: Logger = LoggerFactory.getLogger(UssdService::class.java)

    @Autowired
    lateinit var sessionManager: SessionManager

    @Autowired
    lateinit var navigation: Navigation

    override fun process(
        sessionId: String, phoneNumber: String, networkCode: String, serviceCode: String, text: String
    ): String {
        val cellNumber = phoneNumberWithoutPlus(phoneNumber)
        var session = sessionManager.getSession(sessionId)
        if (session == null) {
            logger.info(
                "Createing a new session with sessionId: $sessionId, " +
                        "" + "serviceCode: $serviceCode, networkCode: $networkCode, " +
                        "" + "cellNumber: $cellNumber , text: $text"
            )
            session = sessionManager.createSession(
                sessionId = sessionId,
                phoneNumber = cellNumber,
                networkCode = networkCode,
                serviceCode = serviceCode,
                text = text
            )
        }
        return processResults(session, text)
    }


    private fun processResults(session: USSDSession, text: String): String {
         val menuState = navigation.menuState(text)
        // Modify here for testing purposes
        // No formating required
        val renderedMenu = navigation.renderMenu(text, RENTSTATUS.PAID)

        // Modify here too for testing purposes
        return when (menuState) {
            MENU.MAIN_MENU -> {
                String.format(renderedMenu, "Iain Mosima")
            }

            MENU.PAY_RENT_MENU -> {
                String.format(renderedMenu, "10,000", "Space Apartments", "B34")
            }
            // More logic here
            MENU.RENT_STATUS -> {
                String.format(renderedMenu, "RentStatus")
            }
            MENU.CANCELED -> {
                renderedMenu
            }
            MENU.INVALID -> {
                "Invalid Option, please try again \n" + renderedMenu
            }
            MENU.STK_PUSH -> {
                renderedMenu
            }
        }



    }

}