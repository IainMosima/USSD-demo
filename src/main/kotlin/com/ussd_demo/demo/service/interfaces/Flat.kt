package com.ussd_demo.demo.service.interfaces

import com.ussd_demo.demo.utils.HouseNumber
import com.ussd_demo.demo.utils.Result

interface Flat {
    fun getFlats(): Result<List<Flat>>
    fun createFlat(flatName: String, location: String, houseNumbers: List<HouseNumber>): Result<Flat>
    fun updateFlat(flatId: String, flatName: String?, location: String?, houseNumbers: List<HouseNumber>?): Result<Flat>
    fun deleteFlat(flatId: String): Result<String>
}