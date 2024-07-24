package com.ussd_demo.demo.utils


object AppConstant {
    val VALID_NAVIGATIONS = arrayOf('0', '1', '2', '#')
    const val APP_CON = "CON"
    const val APP_END = "END"
    const val MAIN_MENU = "Hi %s, what would you like to do? \n1. Pay Rent \nCheck Rent Status"
    const val PAY_RENT_MENU = "Pay Rent of KES: %s, For %s, house number %s \n1. Yes \n2.No"
    const val STK_PUSH = "Please wait for a M-Pesa pin prompt via STK push"
    const val CANCLLLED = "You have canceled the request"
    const val RENT_STATUS = "Your next rent of KES: %s for %s is due %s \n* Go back home"

}