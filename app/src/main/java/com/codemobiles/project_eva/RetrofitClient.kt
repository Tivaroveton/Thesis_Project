package com.codemobiles.project_eva

import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part

interface RetrofitClient {

    @Multipart
    @POST("")
    fun postImageNodeJS(
        @Part image: MultipartBody.Part,
        @Part("username") username: RequestBody,
        @Part("password") password: RequestBody): Call<ResponseBody>

    companion object {
        private val BASE_URL = "http://192.168.0.101:3000/"
        private var mRetrofit: RetrofitClient? = null

        val client: RetrofitClient get() {

            if (mRetrofit == null){
                mRetrofit = Retrofit.Builder().baseUrl(BASE_URL).build().create(RetrofitClient::class.java)
            }

            return mRetrofit!!
        }

    }

//    @FormUrlEncoded()
//    @POST("record_position")
//    fun postPosition(@Field("latitude") lat:Double, @Field("longitude") lng:Double):Call<ResponseBody>
//
//
//    companion object{
//        private val BASE_URL = "http://192.168.0.101:5000/"
//        private var mRetrofit: RetrofitClient? = null
//
//        fun create() : RetrofitClient {
//
//            if (mRetrofit == null){
//                mRetrofit = Retrofit.Builder().baseUrl(BASE_URL)
//                    .addConverterFactory(GsonConverterFactory.create())
//                    .build()
//                    .create(RetrofitClient::class.java)
//            }
//
//            return mRetrofit!!
//        }
//    }
}