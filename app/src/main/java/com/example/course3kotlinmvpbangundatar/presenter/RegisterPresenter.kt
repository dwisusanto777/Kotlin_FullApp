package com.example.course3kotlinmvpbangundatar.presenter

import com.example.course3kotlinmvpbangundatar.ParameterRegister
import com.example.course3kotlinmvpbangundatar.model.gsonArticle.ArticlesItem
import com.example.course3kotlinmvpbangundatar.model.register.RegisterResponse
import com.example.course3kotlinmvpbangundatar.network.NewsApiServiceReactive
import com.example.course3kotlinmvpbangundatar.network.UserService
import com.example.course3kotlinwisataaplikasi.retrofitconfig.RetrofitInstance
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterPresenter(val registerView:RegisterView ) {

    fun register(nama:String, noHp:String, email:String, password:String){
        //registerView.startProgressBarr()
        if(nama.isNotEmpty()&&noHp.isNotEmpty()&&email.isNotEmpty()&&password.isNotEmpty()) {
            // ini menggunakan retrofit reactive
            var service = RetrofitInstance.getInstanceReactvice(ParameterRegister.URL_HOST).create(
                UserService::class.java)
            service.registerReactive(nama, noHp, email, password).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                        response ->
                    registerView.successRegister(response)
                },{
                        e ->
                    registerView.statusMsgRegister(e.localizedMessage)
                })

            // ini menggunkan retrofit standar
//            RetrofitInstance.getInstance(ParameterRegister.URL_HOST).create(UserService::class.java)
//                .register(nama, noHp, email, password)
//                .enqueue(object : Callback<RegisterResponse> {
//                    override fun onResponse(
//                        call: Call<RegisterResponse>,
//                        response: Response<RegisterResponse>
//                    ) {
//                        if (response.isSuccessful) {
//                            val responseServer = response.body()
//                            val message = response.body()?.message
//                            val status = response.body()?.isSuccess
//                            if (status == true) {
//                                registerView.statusMsgRegister("Registrasi Berhasil")
//                                responseServer?.let { registerView.successRegister(it) }
//                            } else {
//                                registerView.statusMsgRegister("Registrasi Gagal")
//                            }
//                        }
//                    }
//
//                    override fun onFailure(call: Call<RegisterResponse>, t: Throwable) {
//                        registerView.statusMsgRegister("Error = "+t.localizedMessage)
//                    }
//                })
        }else{
            registerView.emptyData()
        }
        registerView.stopProgressBarr()
    }

}