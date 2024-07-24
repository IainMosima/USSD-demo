package com.ussd_demo.demo.controller

import com.ussd_demo.demo.service.implementations.UssdService
import jakarta.validation.constraints.Size
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/manage-flats")
class USSDController {
    @Autowired
    lateinit var ussdService: UssdService
    @PostMapping(value = ["service"], produces = [MediaType.TEXT_PLAIN_VALUE])
    @ResponseBody
    suspend fun menu(
        @RequestParam(value = "sessionId") @Size(min = 1, max = 1000) sessionId: String,
        @RequestParam(value = "serviceCode") @Size(min = 1, max = 100) serviceCode: String,
        @RequestParam(value = "networkCode") @Size(min = 1, max = 100) networkCode: String,
        @RequestParam(value = "phoneNumber") @Size(min = 1, max = 15) phoneNumber: String,
        @RequestParam(value = "text") @Size(max = 1000) text: String
    ): String {
        val response = ussdService.process(
            sessionId = sessionId,
            serviceCode = serviceCode,
            networkCode = networkCode,
            phoneNumber = phoneNumber,
            currentMenuItem = text
        )
        return response
    }
}