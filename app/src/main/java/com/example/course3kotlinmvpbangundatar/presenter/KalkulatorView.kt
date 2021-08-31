package com.example.course3kotlinmvpbangundatar.presenter

import com.example.course3kotlinmvpbangundatar.model.Kalkulator

interface KalkulatorView {
    fun bindView(kal:Kalkulator)
    fun isEmpty()
}