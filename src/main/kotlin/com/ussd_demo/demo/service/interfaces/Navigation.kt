package com.ussd_demo.demo.service.interfaces

import com.ussd_demo.demo.data.session.USSDSession
import com.ussd_demo.demo.enum.MENU
import com.ussd_demo.demo.enum.RENTSTATUS
import com.ussd_demo.demo.utils.NavigatorResult

interface Navigation {
    fun menuConstruct(session: USSDSession?, menu: String): String
    fun getLastMenuItem(text: String): String
//    fun getPreviousMenu(text: String): String
    fun renderMenuStatus(message: String?, terminate: Boolean = false): String
    fun renderMenu(session: USSDSession, result: NavigatorResult, menu: String, rentStatus: RENTSTATUS?): String
    fun menuState(menu: String): MENU
    fun renderMenuPayRent(message: String, flatName: String, houseNumber: String, rent: Number): String
    fun renderMenuRentStatus(message: String, flatName: String, houseNumber: String): String
}