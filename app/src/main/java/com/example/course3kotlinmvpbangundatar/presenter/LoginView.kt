package com.example.course3kotlinmvpbangundatar.presenter

import com.example.course3kotlinmvpbangundatar.model.gsonSignin.DataItem

interface LoginView {
    fun loginSuccess(msg:String, user:List<DataItem>)
    fun statusMsgRegister(msg:String)
}