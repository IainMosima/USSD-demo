package com.ussd_demo.demo.enum

enum class Levels(val level: String) {
    NEW_USER("New User"),
    TENANT("Tenant")
}

enum class MENU(val menu: String) {
    MAIN_MENU("Main Menu"),
    PAY_RENT_MENU("Pay Rent Menu"),
    STK_PUSH("Stk Push"),
    CANCELED("Canceled"),
    RENT_STATUS("Rent Status"),
    INVALID("Invalid"),
}

enum class RENTSTATUS(val status: String) {
    PAID("Paid"),
    RECURRING("Recurring"),
    SURPLUS("Surplus")
}