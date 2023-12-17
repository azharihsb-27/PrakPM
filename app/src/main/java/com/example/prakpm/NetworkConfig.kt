package com.example.prakpm

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

object NetworkConfig {
    fun getInterceptor() : OkHttpClient {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY

        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()

        return okHttpClient
    }

    //Retrofit
    fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("http://10.2.2.2/server_api/index.api/ServerApi/")
            .client(getInterceptor())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun getService() = getRetrofit().create(StaffService::class.java)
}

interface StaffService {
    // fungsi create data
    @FormUrlEncoded
    @POST("addStaff")
    fun addStaff(@Field("Name") name: String,
                 @Field("Hp") hp: String,
                 @Field("alamat") alamat: String) : Call<ResultStatus>

    // fungsi get data
    @GET("getDataStaff")
    fun getData() : Call<ResultStatus>

    // fungsi update data
    @FormUrlEncoded
    @POST("updateStaff")
    fun updateStaff(@Field("id") id: String,
                    @Field("name") name: String,
                    @Field("Hp") hp: String,
                    @Field("alamat") alamat: String) : Call<ResultStatus>

}