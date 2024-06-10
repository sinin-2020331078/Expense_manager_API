package com.example.xpensemanager


import android.util.Log
import com.example.xpensemanager.ApiService
import com.example.xpensemanager.ServiceBuilder
import com.example.xpensemanager.Data.otpRequest.ApiResponse
import com.example.xpensemanager.Data.otpRequest.RequestParameters
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
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

fun submit(phone: String) {
    val requestParameters = RequestParameters(
        appId = "APP_118917",
        password= "51fb4f43c564bc9899e2c9acf8b38bc5",
        mobile = phone
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