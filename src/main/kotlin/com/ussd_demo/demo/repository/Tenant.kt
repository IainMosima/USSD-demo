package com.ussd_demo.demo.repository

import org.springframework.data.mongodb.repository.MongoRepository

interface Tenant: MongoRepository<Tenant, String> {
}