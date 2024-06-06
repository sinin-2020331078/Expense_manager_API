package com.example.xpensemanager

import com.example.xpensemanager.Data.otpRequest.ApiResponse
import com.example.xpensemanager.Data.otpRequest.RequestParameters
import com.example.xpensemanager.Data.otpVerify.OtpVerifyResponse
import com.example.xpensemanager.Data.otpVerify.VerifyParameters
import com.example.xpensemanager.Data.subscribe.SubscribeRequestParameters
import com.example.xpensemanager.Data.subscribe.SubscribeResponse
import com.example.xpensemanager.Data.subscription.StatusResponse
import com.example.xpensemanager.Data.subscription.VerifyParametersStatus
import com.example.xpensemanager.Data.unsubscribe.UnsubscribeRequestParameters
import com.example.xpensemanager.Data.unsubscribe.UnsubscribeResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Query

interface ApiService {
    // Define a function for the PUT operation

    @POST("nazmul/subscription/otp/request")
    fun requestOtp(@Body requestParameters: RequestParameters): Call<ApiResponse>

    @POST("nazmul/subscription/otp/verify")
    fun verifyOtp(@Body verifyParameters: VerifyParameters): Call<OtpVerifyResponse>

    @POST("nazmul/subscription/status ")
    fun verifySubscription(@Body verifyParametersStatus: VerifyParametersStatus): Call<StatusResponse>

    @POST("nazmul/subscription/subscribe ")
    fun subscribe(@Body subscribeRequestParameters: SubscribeRequestParameters): Call<SubscribeResponse>

    @POST("nazmul/subscription/unsubscribe ")
    fun unsubscribe(@Body unsubscribeRequestParameters: UnsubscribeRequestParameters): Call<UnsubscribeResponse>


  /*  @POST("renter")
    fun InputRenterInfo(
        @Body renterInfo: RenterInfo // Request body containing updated RenterInfo
    ): Call<Void> // Call object to handle the response



    @POST("owner")
    fun InputOwnerInfo(
        @Body ownerInfo: OwnerInfo // Request body containing updated RenterInfo
    ): Call<Void>

    @POST("rented_flats")
    fun InputRentedFlats(
        @Body rentedFlats: RentedFlats
    ):Call < Void >

    @POST("createflat")
    fun InputFlatInfo(
        @Body flatInfo: FlatInfo
    ):Call<Void>
    @PUT("billstatus")
    fun UpdateBillStatus(
        @Body billStatus: BillStatus
    ):Call<Void>

    @GET("billstatus")
    fun GetBillStatus(
        @Query("flatname") flatname: String
    ):Call<List<BillStatus>>

    @GET("renterinfo")
    fun GetrenterInfo(
        @Query("email") email:String,
        @Query("password") password:String
    ):Call<List<RenterInfo>>

    @GET("ownerinfo")
    fun GetOwnerInfo(
        @Query("email") email:String,
        @Query("password") password:String
    ):Call<List<OwnerInfo>>

    @GET("flatdetails")
    fun GetFlatDetails(
        @Query("flatname") flatname : String
    ):Call<List<RentedFlats>>

    @GET("unitdetails")
    fun GetUnitDetails(
        @Query("code") code : String
    ):Call<List<UnitDetails>>

    @GET("specificunit")
    fun GetSpecificUnit(
        @Query("flatname") flatname: String
    ):Call<List<UnitDetails>>
    @GET("flatcode")
    fun GetFlatCode(
        @Query("flatname") flatname: String
    ):Call<List<FlatCode>>

    @GET("rentedlist")
    fun GetRentedList(
        @Query("email") email : String
    ):Call<List<RentedFlats>>
*/



}