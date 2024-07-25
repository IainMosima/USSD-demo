package com.ussd_demo.demo.model

import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "payment")
data class Payment(
    @Id
    var paymentId: ObjectId? = null,
    var houseNumber: String,
    var rentString: String,
    var amount : Number,
    var datePayed: String,
    var recurringDates: List<String>

)
