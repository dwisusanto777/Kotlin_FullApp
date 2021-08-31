package com.example.course3kotlinmvpbangundatar.presenter

import com.example.course3kotlinmvpbangundatar.model.Kalkulator

class KalkulatorPresenter(val kkView:KalkulatorView) {
    fun hitungCalculator(nilai1:String, nilai2:String, typeData:String){
        if(nilai1.isNotEmpty() && nilai2.isNotEmpty()) {
            val nilaia = nilai1.toInt()
            val nilaib = nilai2.toInt()
            var total = 0
            if (typeData.equals("+")) {
                total = nilaia.plus(nilaib)
            } else if (typeData.equals("-")) {
                total = nilaia.minus(nilaib)
            } else if (typeData.equals("*")) {
                total = nilaia.times(nilaib)
            } else if (typeData.equals("/")) {
                total = nilaia/nilaib
            }
            val kalkulator = Kalkulator();
            kalkulator.total = total
            kkView.bindView(kalkulator)
        }else{
            kkView.isEmpty()
        }
    }
}