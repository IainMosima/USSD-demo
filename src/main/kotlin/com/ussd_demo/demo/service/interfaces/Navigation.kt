package com.ussd_demo.demo.service.interfaces

import com.ussd_demo.demo.data.session.USSDSession
import com.ussd_demo.demo.utils.NavigatorResult

interface Navigation {
    fun menuConstruct(session: USSDSession?, menu: String): String
    fun getLastMenuItem(text: String): String
//    fun getPreviousMenu(text: String): String
    fun renderMenuStatus(message: String?, terminate: Boolean): String
    fun renderMenu(session: USSDSession, result: NavigatorResult, menu: String): String

}