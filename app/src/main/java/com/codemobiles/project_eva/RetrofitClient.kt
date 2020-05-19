package com.codemobiles.project_eva

import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Field
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path


interface RetrofitClient {

//    @Multipart
//    @POST("")
//    fun postImageNodeJS(
//        @Part image: MultipartBody.Part,
//        @Part("username") username: RequestBody,
//        @Part("password") password: RequestBody
//    ): Call<ResponseBody>

    @GET("/auth/'{USERNAME}'/'{PASSWORD}'")
    fun getLogin(
        @Path("USERNAME") USERNAME: String,
        @Path("PASSWORD") PASSWORD: String
    ): Call<LoginClass>

    @GET("/mainpage/m/{staffID}")
    fun getLProject(@Path("staffID") staffID: String): Call<ProjectClass>

    @GET("/information/getData/m/'{projectName}'")
    fun getData(@Path("projectName") projectName: String): Call<DataClass>

    @POST("/information/m/newdata/add")
    fun postData(
        @Field("projectName") projectName: String,
        @Field("buildingName") buildingName: String,
        @Field("inspectiondate") inspectiondate: String,
        @Field("latitude") latitude: Float,
        @Field("longtitude") longtitude: Float,
        @Field("districtID") districtID: Int,
        @Field("districtName") districtName: String,
        @Field("subdistrictID") subdistrictID: Int,
        @Field("subdistrictName") subdistrictName: String,
        @Field("haveBTS") haveBTS: Int?,
        @Field("haveMRT") haveMRT: Int?,
        @Field("haveBRT") haveBRT: Int,
        @Field("nearestBTS") nearestBTS: String,
        @Field("distanceFromBTS") distanceFromBTS: Int,
        @Field("buildingFloor") buildingFloor: Int,
        @Field("units") units: Int,
        @Field("buildingAge") buildingAge: Int,
        @Field("buildingCondition") buildingCondition: Int,
        @Field("lobby") lobby: Int,
        @Field("lift") lift: Int?,
        @Field("swimmingPool") swimmingPool: Int,
        @Field("fitness") fitness: Int,
        @Field("suana") suana: Int,
        @Field("jacuzzi") jacuzzi: Int,
        @Field("steam") steam: Int,
        @Field("library") library: Int,
        @Field("garden") garden: Int?,
        @Field("kidplay") kidplay: Int,
        @Field("parklot") parklot: Int,
        @Field("automateParklot") automateParklot: Int,
        @Field("golfCourse") golfCourse: Int,
        @Field("movieRoom") movieRoom: Int?,
        @Field("shop") shop: Int,
        @Field("camFee") camFee: Float,
        @Field("floor") floor: String,
        @Field("areaRoom") areaRoom: Float,
        @Field("pricebyGov") pricebyGov: Int,
        @Field("fireInsurance") fireInsurance: Int,
        @Field("roomType") roomType: Int,
        @Field("roomPosition") roomPosition: Int?,
        @Field("roomView") roomView: Int,
        @Field("materialDesign") materialDesign: Int,
        @Field("maintananceCondition") maintananceCondition: Int
    ): Call<DataClass?>?

//    @GET('/mainpage/m/{staffID}')

    companion object {
        var okHttpClient = OkHttpClient()

        private val BASE_URL = "http://34.80.221.103:3000"

        fun login_create(): RetrofitClient {

            val retrofit = retrofit2.Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofit.create(RetrofitClient::class.java)
        }

        fun project_create(): RetrofitClient {

            val retrofit = retrofit2.Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofit.create(RetrofitClient::class.java)
        }

        fun data_create(): RetrofitClient {

            val retrofit = retrofit2.Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofit.create(RetrofitClient::class.java)
        }

        fun dataPost_create(): RetrofitClient {

            val retrofit = retrofit2.Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofit.create(RetrofitClient::class.java)
        }
    }

}