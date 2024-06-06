package com.example.xpensemanager.Data.otpRequest

data class ApiResponse(
    val statusCode: String,
    val statusDetail: String,
    val referenceNo: String,
    val version: String
)