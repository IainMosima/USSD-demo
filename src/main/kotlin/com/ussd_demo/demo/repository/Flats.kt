package com.ussd_demo.demo.repository

import com.ussd_demo.demo.model.Flats
import org.springframework.data.mongodb.repository.MongoRepository

interface Flats: MongoRepository<Flats, String> {
}