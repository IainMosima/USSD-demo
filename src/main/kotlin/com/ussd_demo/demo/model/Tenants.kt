package com.ussd_demo.demo.model

import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "tenants")
data class Tenants(
    @Id
    var tenantId: ObjectId? = null,
    var firstName: String? = null,
    var lastName: String? = null,
    var phoneNumber: String? = null,
)
