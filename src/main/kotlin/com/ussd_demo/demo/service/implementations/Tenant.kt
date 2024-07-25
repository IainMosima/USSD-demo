package com.ussd_demo.demo.service.implementations

import com.ussd_demo.demo.service.interfaces.Tenant
import com.ussd_demo.demo.utils.Result

class Tenant: Tenant {
    override fun getTenants(): Result<List<com.ussd_demo.demo.model.Tenant>> {
        TODO("Not yet implemented")
    }

    override fun createTenant(
        firstName: String,
        lastName: String,
        phoneNumber: String
    ): Result<com.ussd_demo.demo.model.Tenant> {
        TODO("Not yet implemented")
    }

    override fun updateTenant(
        tenantId: String,
        firstName: String?,
        lastName: String?,
        phoneNumber: String?
    ): Result<String> {
        TODO("Not yet implemented")
    }

    override fun deleteTenant(paymentId: String): Result<String> {
        TODO("Not yet implemented")
    }
}