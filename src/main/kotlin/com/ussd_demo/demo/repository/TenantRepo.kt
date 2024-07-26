package com.ussd_demo.demo.repository

import com.ussd_demo.demo.model.Tenant
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface TenantRepo: MongoRepository<Tenant, String> {

}