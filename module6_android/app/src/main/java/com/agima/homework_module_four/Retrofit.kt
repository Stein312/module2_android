package com.agima.homework_module_four

import android.os.Message
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

object RetrofitClient {
    val retrofit: AgimaEdApi = Retrofit.Builder()
            .baseUrl("https://agimaskillbox.herokuapp.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(AgimaEdApi::class.java)
}

interface AgimaEdApi {
    @GET("authentication")
    fun auth():Call<AuthResponse>

    @POST("message")
    fun message(@Body form: FormRequest):Call<String>

}

data class AuthResponse(
        val access_token:String,
        val refresh_token:String,
        val expires_in:String
)

data class FormRequest(
        val access_token:String,
        val name:String,
        val surname:String,
        val message: String
)