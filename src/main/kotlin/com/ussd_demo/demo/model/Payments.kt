package com.ussd_demo.demo.model

import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "payments")
data class Payments(
    @Id
    var paymentId: ObjectId? = null,
    var houseNumber: String,
    var rentString: String,
    var amount : Number,
    var datePayed: String,
    var recurringMonths: List<String>

)
