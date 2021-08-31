package com.example.course3kotlinmvpbangundatar.presenter

import com.example.course3kotlinmvpbangundatar.model.Hasil

class PersegiPanjangPresenter(var ppView : PersegiPanjangView) {

    fun hitung(panjang:String, lebar:String){
        val cpanjang = panjang.toInt()
        val clebar = lebar.toInt()
        val total = cpanjang.times(clebar)

        val hasil = Hasil();
        hasil.total = total

        ppView.hasilHitung(hasil)
    }

}