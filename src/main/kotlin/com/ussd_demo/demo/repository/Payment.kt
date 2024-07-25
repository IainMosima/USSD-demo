package com.ussd_demo.demo.repository

import com.ussd_demo.demo.model.Payment
import org.springframework.data.mongodb.repository.MongoRepository

interface Payment:MongoRepository<Payment, String> {
}