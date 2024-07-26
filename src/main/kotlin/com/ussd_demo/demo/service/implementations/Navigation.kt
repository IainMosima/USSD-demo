package com.ussd_demo.demo.service.implementations

import com.ussd_demo.demo.data.session.USSDSession
import com.ussd_demo.demo.enum.MENU
import com.ussd_demo.demo.enum.RENTSTATUS
import com.ussd_demo.demo.service.interfaces.Navigation
import com.ussd_demo.demo.utils.AppConstant
import com.ussd_demo.demo.utils.NavigatorResult
import org.springframework.stereotype.Service

@Service
class Navigation : Navigation {
    override fun menuConstruct(session: USSDSession?, menu: String): String {
        val lastUserInput = getLastMenuItem(menu)
        val parts = menu.split("*").toMutableList()
        if (session != null)
            when {
                lastUserInput == "0" && parts.size == 2 -> {
                    parts.removeLast()
                    return parts.joinToString("*")
                }

                lastUserInput == "#" && parts.size == 2 -> return ""
                else -> return ""
            }
        return menu
    }

    override fun getLastMenuItem(text: String): String {
        val textArr = text.split("*")
        return textArr[textArr.size - 1]
    }

    override fun menuState(menu: String): MENU {
        val parts = menu.split("*")
        val partsSize = parts.size
        when {
            menu == "" -> return MENU.MAIN_MENU
            partsSize == 1 && parts[0] == "1" -> {
                return MENU.PAY_RENT_MENU;
            }

            partsSize == 1 && parts[0] == "2" -> {
                return MENU.RENT_STATUS
            }

            partsSize == 2 && parts[0] == "1" && parts[1] == "1" -> {
                return MENU.STK_PUSH
            }

            partsSize == 2 && parts[0] == "1" && parts[1] == "2" -> {
                return MENU.CANCELED
            }
        }
        return MENU.INVALID
    }

    override fun renderMenuStatus(message: String?, terminate: Boolean): String {
        return if (terminate) "${AppConstant.APP_CON} $message" else "${AppConstant.APP_END} $message"
    }

    override fun renderMenu(
        menu: String,
        rentStatus: RENTSTATUS?
    ): String {
        when {
            menuState(menu) == MENU.PAY_RENT_MENU -> {
                return AppConstant.PAY_RENT_MENU
            }

            menuState(menu) == MENU.RENT_STATUS -> {
                if (rentStatus != null)
                    when (rentStatus) {
                        RENTSTATUS.PAID -> AppConstant.PAID_RENT_STATUS
                        RENTSTATUS.RECURRING -> AppConstant.RECURRING_RENT_STATUS
                        RENTSTATUS.SURPLUS -> AppConstant.SURPLUS_RENT_STATUS
                    }
            }

            menuState(menu) == MENU.STK_PUSH -> {
                return AppConstant.STK_PUSH
            }

            menuState(menu) == MENU.CANCELED -> {
                return AppConstant.CANCELED
            }
        }
        return AppConstant.MAIN_MENU
    }

    override fun renderMenuPayRent(message: String, flatName: String, houseNumber: String, rent: Number): String {
        val formattedRent = String.format("%,d", rent)
        return String.format(message, formattedRent, flatName, houseNumber)
    }

    override fun renderMenuRentStatus(message: String, flatName: String, houseNumber: String): String {
        TODO("Not yet implemented")
    }
}