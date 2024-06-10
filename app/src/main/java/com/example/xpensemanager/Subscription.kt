package com.example.xpensemanager

import android.util.Log
import com.example.xpensemanager.ApiService
import com.example.xpensemanager.ServiceBuilder
import com.example.xpensemanager.Data.subscribe.SubscribeRequestParameters
import com.example.xpensemanager.Data.subscribe.SubscribeResponse
import com.example.xpensemanager.Data.unsubscribe.UnsubscribeRequestParameters
import com.example.xpensemanager.Data.unsubscribe.UnsubscribeResponse
import androidx.compose.foundation.clickable
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.xpensemanager.DestinationScreen
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.semantics.Role.Companion.Button
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.xpensemanager.CheckSignedIn
import com.example.xpensemanager.CommonProcessBar
import com.example.xpensemanager.XMViewModel
import com.example.xpensemanager.navigateTo


import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

fun subscriptionOn(navController: NavController, phone: String) {
    val subscribeRequestParameters = SubscribeRequestParameters(
        appId= "APP_118917",
        password= "51fb4f43c564bc9899e2c9acf8b38bc5",
        mobile= phone
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

fun subscriptionOff(phone: String) {
    val unsubscribeRequestParameters = UnsubscribeRequestParameters(
        appId= "APP_118917",
        password= "51fb4f43c564bc9899e2c9acf8b38bc5",
        mobile= phone
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