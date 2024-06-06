package com.example.xpensemanager

import android.util.Log
import com.example.xpensemanager.ApiService
import com.example.xpensemanager.ServiceBuilder
import com.example.xpensemanager.Data.subscribe.SubscribeRequestParameters
import com.example.xpensemanager.Data.subscribe.SubscribeResponse
import com.example.xpensemanager.Data.unsubscribe.UnsubscribeRequestParameters
import com.example.xpensemanager.Data.unsubscribe.UnsubscribeResponse


import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

fun subscriptionOn() {
    val subscribeRequestParameters = SubscribeRequestParameters(
        appId= "APP_118917",
        password= "51fb4f43c564bc9899e2c9acf8b38bc5",
        mobile= "8801641354013"
    )
    //"appId": "APP_118917",
    ////    "password": "51fb4f43c564bc9899e2c9acf8b38bc5",
    ////    "mobile": "8801641354013"
    val destinationService = ServiceBuilder.buildService(ApiService::class.java)
    val requestCall = destinationService.subscribe(subscribeRequestParameters)

    requestCall.enqueue(object : Callback<SubscribeResponse> {
        override fun onResponse(
            call: Call<SubscribeResponse>,
            response: Response<SubscribeResponse>
        ) {
            if (response.isSuccessful) {
                val apiResponse = response.body()
                Log.d("MyActivity", "Subscription request sent successfully: $apiResponse")
            } else {
                // Handle unsuccessful response
                Log.e("MyActivity", "Failed to send subscription request: ${response.errorBody()?.string()}")
            }
        }
        override fun onFailure(call: Call<SubscribeResponse>, t: Throwable) {
            // Handle failure
            Log.e("MyActivity", "Network error: ${t.message}")
        }
    })
}

fun subscriptionOff() {
    val unsubscribeRequestParameters = UnsubscribeRequestParameters(
        appId= "APP_118917",
        password= "51fb4f43c564bc9899e2c9acf8b38bc5",
        mobile= "8801641354013"
    )
    val destinationService = ServiceBuilder.buildService(ApiService::class.java)
    val requestCall = destinationService.unsubscribe(unsubscribeRequestParameters)

    requestCall.enqueue(object : Callback<UnsubscribeResponse> {
        override fun onResponse(
            call: Call<UnsubscribeResponse>,
            response: Response<UnsubscribeResponse>
        ) {
            if (response.isSuccessful) {
                val apiResponse = response.body()
                Log.d("MyActivity", "Unsubscription request sent successfully: $apiResponse")
            } else {
                // Handle unsuccessful response
                Log.e("MyActivity", "Failed to send unsubscription request: ${response.errorBody()?.string()}")
            }
        }
        override fun onFailure(call: Call<UnsubscribeResponse>, t: Throwable) {
            // Handle failure
            Log.e("MyActivity", "Network error: ${t.message}")
        }
    })
}