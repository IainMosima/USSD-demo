package com.ussd_demo.demo.service.implementations

import com.ussd_demo.demo.data.session.USSDSession
import com.ussd_demo.demo.service.interfaces.Navigation
import com.ussd_demo.demo.utils.AppConstant
import com.ussd_demo.demo.utils.NavigatorResult

class Navigation: Navigation {
    override fun menuConstruct(session: USSDSession?, menu: String): String {
        val lastUserInput = getLastMenuItem(menu)
        val parts = menu.split("*").toMutableList()
        if(session != null)
            when {
                lastUserInput == "0" && parts.size == 2 -> {
                    parts.removeLast()
                    return parts.joinToString("*")
                }
                lastUserInput == "#" && parts.size == 2 -> return ""
                else -> return "${session.currentMenuItem}*$lastUserInput"
            }
        return menu
    }

    override fun getLastMenuItem(text: String): String {
        val textArr = text.split("*")
        return textArr[textArr.size - 1]
    }

    override fun renderMenuStatus(message: String?, terminate: Boolean): String {
        return if (terminate) "${AppConstant.APP_CON} $message" else "${AppConstant.APP_END} $message"
    }

    override fun renderMenu(session: USSDSession, result: NavigatorResult, menu: String): String {
        val parts = menu.split("*")
        val partsSize = parts.size
        when {
            partsSize == 1 && parts[0] == "1" -> {
                return AppConstant.PAY_RENT_MENU
            }
            partsSize == 1 && parts[0] == "2" -> {
                return AppConstant.RENT_STATUS
            }
            partsSize == 2 && parts[0] == "1" && parts[1] == "1" -> {
                return AppConstant.STK_PUSH
            }
            partsSize == 2 && parts[0] == "1" && parts[1] == "2" -> {
                return AppConstant.CANCLLLED
            }
        }
        return AppConstant.MAIN_MENU
    }
}