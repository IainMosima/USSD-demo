package com.ussd_demo.demo.service.implementations

import com.ussd_demo.demo.enum.RENTSTATUS
import com.ussd_demo.demo.service.interfaces.Flat
import com.ussd_demo.demo.service.interfaces.Payment
import com.ussd_demo.demo.utils.Result

class Payment: Payment {
    override fun getPayments(): Result<List<Payment>> {
        TODO("Not yet implemented")
    }

    override fun createPayment(
        tenantId: String,
        houseNumber: String,
        rentStatus: RENTSTATUS,
        amount: Number,
        datePayed: String,
        recurringDates: List<String>
    ): Result<Payment> {
        TODO("Not yet implemented")
    }

    override fun updatePayment(
        paymentId: String,
        tenantId: String?,
        houseNumber: String?,
        rentStatus: RENTSTATUS?,
        amount: Number?,
        datePayed: String?,
        recurringDates: List<String>?
    ): Result<Flat> {
        TODO("Not yet implemented")
    }

    override fun deletePayment(paymentId: String): Result<String> {
        TODO("Not yet implemented")
    }
}