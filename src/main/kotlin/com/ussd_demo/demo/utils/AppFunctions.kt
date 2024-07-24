package com.ussd_demo.demo.utils

object AppFunctions {
    fun phoneNumberWithoutPlus(phoneNumber: String): String {
        val regex = "\\+"
        return phoneNumber.replaceFirst(regex.toRegex(), "").trim()
    }
}