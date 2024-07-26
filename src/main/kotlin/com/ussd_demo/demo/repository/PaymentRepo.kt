package com.ussd_demo.demo.repository

import com.ussd_demo.demo.model.Payment
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface PaymentRepo:MongoRepository<Payment, String> {
}