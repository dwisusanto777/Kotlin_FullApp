package com.example.course3kotlinmvpbangundatar.presenter

import com.example.course3kotlinmvpbangundatar.model.register.RegisterResponse

interface RegisterView {
    fun successRegister(response:RegisterResponse)
    fun statusMsgRegister(msg:String)
    fun emptyData()
    fun startProgressBarr()
    fun stopProgressBarr()
}