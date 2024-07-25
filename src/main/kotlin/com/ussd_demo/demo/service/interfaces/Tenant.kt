package com.ussd_demo.demo.service.interfaces

import com.ussd_demo.demo.enum.RENTSTATUS
import com.ussd_demo.demo.model.Tenant
import com.ussd_demo.demo.utils.Result

interface Tenant {
    fun getTenants(): Result<List<Tenant>>
    fun createTenant(firstName: String, lastName: String, phoneNumber: String): Result<Tenant>
    fun updateTenant(tenantId: String, firstName: String?, lastName: String?, phoneNumber: String?): Result<String>
    fun deleteTenant(paymentId: String): Result<String>
}