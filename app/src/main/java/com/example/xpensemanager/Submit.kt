package com.example.xpensemanager


import android.util.Log
import com.example.xpensemanager.ApiService
import com.example.xpensemanager.ServiceBuilder
import com.example.xpensemanager.Data.otpRequest.ApiResponse
import com.example.xpensemanager.Data.otpRequest.RequestParameters
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

fun submit() {
    val requestParameters = RequestParameters(
        appId = "APP_118917",
        password= "51fb4f43c564bc9899e2c9acf8b38bc5",
        mobile = "8801641354013"
    )


    val destinationService = ServiceBuilder.buildService(ApiService::class.java)
    val requestCall = destinationService.requestOtp(requestParameters)

    requestCall.enqueue(object : Callback<ApiResponse> {
        override fun onResponse(call: Call<ApiResponse>, response: Response<ApiResponse>) {
            if (response.isSuccessful) {
                val apiResponse = response.body()
                if (apiResponse != null) {
                    verifyParameters.referenceNo = apiResponse.referenceNo
                }
                Log.d("MyActivity", "OTP sent successfully: $apiResponse")
            } else {
                // Handle unsuccessful response
                Log.e("MyActivity", "Failed to send OTP: ${response.errorBody()?.string()}")
            }
        }
        override fun onFailure(call: Call<ApiResponse>, t: Throwable) {
            // Handle failure
            Log.e("MyActivity", "Network error: ${t.message}")
        }
    })
}