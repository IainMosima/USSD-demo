package com.ussd_demo.demo.repository

import com.ussd_demo.demo.model.Payments
import org.springframework.data.mongodb.repository.MongoRepository

interface Payments:MongoRepository<Payments, String> {
}