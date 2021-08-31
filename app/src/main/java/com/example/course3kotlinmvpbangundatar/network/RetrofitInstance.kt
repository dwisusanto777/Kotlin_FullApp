package com.example.course3kotlinwisataaplikasi.retrofitconfig

import com.example.course3kotlinmvpbangundatar.network.RetrofitSupportSsl
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInstance {

    companion object{
        fun getInstance(url:String):Retrofit{
            val retrofit = Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create() )
                .client(RetrofitSupportSsl.getSupportSSL().build())
                .build();
            return retrofit;
        }
        fun getInstanceReactvice(url:String):Retrofit{
            val retrofit = Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create() )
                .client(RetrofitSupportSsl.getSupportSSL().build())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .build();
            return retrofit;
        }
    }


}