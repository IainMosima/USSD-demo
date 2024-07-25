package com.ussd_demo.demo.service.implementations

import com.ussd_demo.demo.service.interfaces.Flat
import com.ussd_demo.demo.utils.HouseNumber
import com.ussd_demo.demo.utils.Result

class Flat: Flat {
    override fun getFlats(): Result<List<Flat>> {
        TODO("Not yet implemented")
    }

    override fun createFlat(flatName: String, location: String, houseNumbers: List<HouseNumber>): Result<Flat> {
        TODO("Not yet implemented")
    }

    override fun updateFlat(
        flatId: String,
        flatName: String?,
        location: String?,
        houseNumbers: List<HouseNumber>?
    ): Result<Flat> {
        TODO("Not yet implemented")
    }

    override fun deleteFlat(flatId: String): Result<String> {
        TODO("Not yet implemented")
    }
}