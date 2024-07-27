package com.ussd_demo.demo.utils

import com.ussd_demo.demo.enum.RENTSTATUS


data class HouseNumber (
    var number: String,
    var price: Number
)

data class RentInfo (
    val rentstatus: RENTSTATUS,
    val recurringMonths: String
)