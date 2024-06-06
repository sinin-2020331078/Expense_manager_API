package com.example.xpensemanager

import android.util.Log
import com.example.xpensemanager.Data.otpVerify.OtpVerifyResponse
import com.example.xpensemanager.Data.otpVerify.VerifyParameters
import com.example.xpensemanager.Data.subscription.StatusResponse
import com.example.xpensemanager.Data.subscription.VerifyParametersStatus
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


val verifyParameters = VerifyParameters(
    appId= "APP_118917",
    password= "51fb4f43c564bc9899e2c9acf8b38bc5",
    referenceNo = "",
    otp = ""
)

fun verify(otp: String) {
    verifyParameters.otp = otp
    Log.d("MyActivity", "$verifyParameters")
    val destinationService = ServiceBuilder.buildService(ApiService::class.java)
    val requestCall = destinationService.verifyOtp(verifyParameters)

    requestCall.enqueue(object : Callback<OtpVerifyResponse> {
        override fun onResponse(
            call: Call<OtpVerifyResponse>,
            response: Response<OtpVerifyResponse>
        ) {
            if (response.isSuccessful) {
                val apiResponse = response.body()
                Log.d("MyActivity", "OTP verified successfully: $apiResponse")

            } else {
                // Handle unsuccessful response
                Log.e("MyActivity", "Failed to verify OTP: ${response.errorBody()?.string()}")
            }
        }
        override fun onFailure(call: Call<OtpVerifyResponse>, t: Throwable) {
            // Handle failure
            Log.e("MyActivity", "Network error: ${t.message}")
        }
    })
}

fun verifyStatus() {
    val verifyParametersStatus = VerifyParametersStatus(
        appId= "APP_118917",
        password= "51fb4f43c564bc9899e2c9acf8b38bc5",
        mobile= "8801641354013"
    )
    val destinationService = ServiceBuilder.buildService(ApiService::class.java)
    val requestCall = destinationService.verifySubscription(verifyParametersStatus)

    requestCall.enqueue(object : Callback<StatusResponse> {
        override fun onResponse(call: Call<StatusResponse>, response: Response<StatusResponse>) {
            if (response.isSuccessful) {
                val apiResponse = response.body()
                Log.d("MyActivity", "Subscription Status verified successfully: $apiResponse")

            } else {
                // Handle unsuccessful response
                Log.e("MyActivity", "Failed to verify Subscription Status: ${response.errorBody()?.string()}")

            }
        }
        override fun onFailure(call: Call<StatusResponse>, t: Throwable) {
            // Handle failure
            Log.e("MyActivity", "Network error: ${t.message}")
        }
    })
}