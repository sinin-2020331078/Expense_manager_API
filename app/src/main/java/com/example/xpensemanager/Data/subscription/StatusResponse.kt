package com.example.xpensemanager.Data.subscription

data class StatusResponse(
    val version: String,
    val statusCode: String,
    val statusDetail: String,
    val subscriptionStatus: String
)