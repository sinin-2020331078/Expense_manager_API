package com.example.xpensemanager.Data.otpVerify

data class OtpVerifyResponse (

        val statusCode: String,
        val version: String,
        val subscriptionStatus: String,
        val statusDetail: String,
        val subscriberId: String
    )