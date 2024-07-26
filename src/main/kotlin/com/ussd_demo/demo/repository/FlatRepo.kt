package com.ussd_demo.demo.repository

import com.ussd_demo.demo.model.Flat
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface FlatRepo: MongoRepository<Flat, String> {
}