package com.ussd_demo.demo.model

import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "tenant")
data class Tenant(
    @Id
    var tenantId: ObjectId? = null,
    var firstName: String,
    var lastName: String,
    @Indexed(unique = true)
    var phoneNumber: String,
)
