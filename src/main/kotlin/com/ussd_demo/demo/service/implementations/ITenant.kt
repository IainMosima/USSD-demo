package com.ussd_demo.demo.service.implementations

import com.ussd_demo.demo.model.Tenant
import com.ussd_demo.demo.repository.TenantRepo
import com.ussd_demo.demo.service.interfaces.TenantInterface
import com.ussd_demo.demo.utils.Result
import com.ussd_demo.demo.utils.ResultFactory
import org.springframework.beans.factory.annotation.Autowired

class ITenant(
    @Autowired val tenantRepo: TenantRepo
) : TenantInterface {

    override fun getTenants(): Result<List<Tenant>> {
        var allTenants = tenantRepo.findAll()
        return ResultFactory.getSuccessResult(data = allTenants)
    }

    override fun createTenant(
        firstName: String,
        lastName: String,
        phoneNumber: String
    ): Result<Tenant> {
        val newTenant = Tenant(
            firstName = firstName,
            lastName = lastName,
            phoneNumber = phoneNumber
        )
        val savedTenant = tenantRepo.save(newTenant)
        return ResultFactory.getSuccessResult(data = savedTenant, msg = "Successfully created Tenant")
    }

    override fun updateTenant(
        tenantId: String,
        firstName: String?,
        lastName: String?,
        phoneNumber: String?
    ): Result<String> {
        val updatedTenant = tenantRepo.findById(tenantId).map { existingTenant ->
            val updatedTenant = existingTenant.copy(
                firstName = firstName ?: existingTenant.firstName,
                lastName = lastName ?: existingTenant.lastName,
                phoneNumber = phoneNumber ?: existingTenant.phoneNumber
            )
            tenantRepo.save(updatedTenant)
        }.orElse(null)
        return if (updatedTenant != null) {
            ResultFactory.getSuccessResult("Successfully updated Tenant")
        } else {
            ResultFactory.getFailResult("Failed to update Tenant")
        }
    }

    override fun deleteTenant(tenantId: String): Result<String> {
        return try {
            tenantRepo.deleteById(tenantId)
            ResultFactory.getSuccessResult(msg = "Successfully deleted Tenant")
        } catch (e: Exception) {
            ResultFactory.getFailResult("Failed to delete Tenant")
        }
    }
}