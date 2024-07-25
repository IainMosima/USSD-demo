package com.ussd_demo.demo.utils


data class Result<T>(
    val success: Boolean,
    val msg: String? = null,
    val data: T? = null
)

data class CodedResult<T>(
    val success: Boolean,
    val msg: String? = null,
    val code: String? = null,
    val data: T? = null
)