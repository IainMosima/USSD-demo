package com.ussd_demo.demo.model

import com.ussd_demo.demo.utils.HouseNumber
import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "flat")
data class Flat (
    @Id
    var flatId: ObjectId? = null,
    var flatName: String,
    var location: String,
    var houseNumbers: List<HouseNumber>
)