package com.ussd_demo.demo.service.implementations

import com.ussd_demo.demo.data.session.USSDSession
import com.ussd_demo.demo.enum.MENU
import com.ussd_demo.demo.enum.RENTSTATUS
import com.ussd_demo.demo.service.interfaces.SessionManager
import com.ussd_demo.demo.service.interfaces.UssdService
import com.ussd_demo.demo.utils.AppFunctions.phoneNumberWithoutPlus
import com.ussd_demo.demo.utils.RentInfo
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UssdService : UssdService {


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
        // these next 2 line should be fetched from the db in the future
        val rentInfo = RentInfo(
            rentstatus = RENTSTATUS.RECURRING,
            recurringMonths = "May-2024 and Jun-2024"
        )

        val recurringMonths = "May-2024 and Jun-2024"
        val constructedMenu = navigation.menuConstruct(session, text)

        // menuState and rendered menu are dependable
         val menuState = navigation.menuState(constructedMenu)

        // Modify here for testing purposes
        // No formating required
        val renderedMenu = navigation.renderMenu(constructedMenu, rentInfo.rentstatus)

        // Modify here too for testing purposes


        return menuStateHandler(text, menuState, renderedMenu, rentInfo);

    }

    private fun menuStateHandler(text: String, menuState: MENU, renderedMenu: String, rentInfo: RentInfo): String {
        return when (menuState) {
            MENU.MAIN_MENU -> navigation.isMenuValid(text) + String.format(renderedMenu, "Iain Mosima")
            MENU.PAY_RENT_MENU -> String.format(renderedMenu, "10,000", "Space Apartments", "B34")

            // More logic here
            MENU.RENT_STATUS -> {
                when(rentInfo.rentstatus) {
                    RENTSTATUS.PAID -> renderedMenu
                    RENTSTATUS.RECURRING -> String.format(renderedMenu, "20,000", rentInfo.recurringMonths)
                    RENTSTATUS.SURPLUS -> String.format(renderedMenu, "20,000", rentInfo.recurringMonths)
                }
            }
            else -> renderedMenu
        }
    }

}