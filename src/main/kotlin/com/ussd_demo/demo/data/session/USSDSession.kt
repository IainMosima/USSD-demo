package com.ussd_demo.demo.data.session

data class USSDSession(
    val sessionId: String,
    val serviceCode: String,
    val phoneNumber: String,
    val networkCode: String,
    var text: String,
)
