package com.ussd_demo.demo.service.interfaces

import com.ussd_demo.demo.enum.RENTSTATUS
import com.ussd_demo.demo.utils.Result

interface Payment {
    fun getPayments(): Result<List<Payment>>
    fun createPayment(tenantId: String, houseNumber: String, rentStatus: RENTSTATUS, amount: Number, datePayed: String, recurringDates: List<String>): Result<Payment>
    fun updatePayment(paymentId: String, tenantId: String?, houseNumber: String?, rentStatus: RENTSTATUS?, amount: Number?, datePayed: String?, recurringDates: List<String>?): Result<Flat>
    fun deletePayment(paymentId: String): Result<String>
}