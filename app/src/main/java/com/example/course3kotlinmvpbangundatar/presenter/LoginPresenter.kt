package com.example.course3kotlinmvpbangundatar.presenter

import com.example.course3kotlinmvpbangundatar.ParameterRegister
import com.example.course3kotlinmvpbangundatar.model.gsonSignin.DataItem
import com.example.course3kotlinmvpbangundatar.model.gsonSignin.SigninResponse
import com.example.course3kotlinmvpbangundatar.model.register.RegisterResponse
import com.example.course3kotlinmvpbangundatar.network.UserService
import com.example.course3kotlinwisataaplikasi.retrofitconfig.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginPresenter(val login : LoginView) {

    fun login(email:String, password:String){
        if(email.isNotEmpty() && password.isNotEmpty()) {
            RetrofitInstance.getInstance(ParameterRegister.URL_HOST).create(UserService::class.java)
                .login(email, password)
                .enqueue(object : Callback<SigninResponse> {
                    override fun onResponse(
                        call: Call<SigninResponse>,
                        response: Response<SigninResponse>
                    ) {
                        if (response.isSuccessful) {
                            val status = response.body()?.isSuccess
                            val msg = response.body()?.message
                            if (status == true) {
                                msg?.let {
                                    login.loginSuccess(
                                        it,
                                        response.body()?.data as List<DataItem>
                                    )
                                }
                            } else {
                                login.statusMsgRegister(msg ?: "")
                            }
                        }
                    }

                    override fun onFailure(call: Call<SigninResponse>, t: Throwable) {
                        login.statusMsgRegister("Error data = " + t.localizedMessage)
                    }
                });
        }else{
            login.statusMsgRegister("User id dan Password tidak boleh kosong")
        }
    }
}