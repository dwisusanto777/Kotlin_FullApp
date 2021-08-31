package com.example.course3kotlinmvpbangundatar.network

import com.example.course3kotlinmvpbangundatar.model.gsonSignin.SigninResponse
import com.example.course3kotlinmvpbangundatar.model.register.RegisterResponse
import io.reactivex.rxjava3.core.Single
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface UserService {

    @FormUrlEncoded
    @POST("Register.php")
    fun register(
        @Field("nama") nama : String,
        @Field("nohp") noHp : String,
        @Field("email") email : String,
        @Field("password") password : String
    ):Call<RegisterResponse>

    @FormUrlEncoded
    @POST("Login.php")
    fun login(
        @Field("email") email : String,
        @Field("password") password : String
    ):Call<SigninResponse>

    @FormUrlEncoded
    @POST("Register.php")
    fun registerReactive(
        @Field("nama") nama : String,
        @Field("nohp") noHp : String,
        @Field("email") email : String,
        @Field("password") password : String
    ):Single<RegisterResponse>

}