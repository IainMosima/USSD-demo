package com.ussd_demo.demo.model

import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "flats")
data class Flats (
    @Id
    var flatId: ObjectId? = null,
    var flatName: String,
    var location: String,
    var houseNumbers: List<HouseNumber>
)

data class HouseNumber (
    var number: String,
    var price: Number
)