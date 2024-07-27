package com.ussd_demo.demo.utils


object AppConstant {
    val VALID_NAVIGATIONS = charArrayOf('0', '1', '2', '#', ' ')
    const val APP_CON = "CON"
    const val APP_END = "END"
    const val MAIN_MENU = "Hi %s, what would you like to do? \n1. Pay Rent \n2. Check Rent Status"
    const val PAY_RENT_MENU = "Pay Rent of KES: %s, For %s, house number %s \n1. Yes \n2. No \n0. Go back"
    const val STK_PUSH = "Please wait for a M-Pesa pin prompt via STK push"
    const val INVALID = "Invalid option, please try again \n#. Home"
    const val CANCELED = "You have canceled the request"
    const val PAID_RENT_STATUS = "All good, you have no recurring payment. \n#. Home"
    const val RECURRING_RENT_STATUS = "You have a recurring payment of Kes: %s, from %s \n#. Home"
    const val SURPLUS_RENT_STATUS = "You gave a surplus payment of KES 10,000"

}