package com.example.course3kotlinmvpbangundatar.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.course3kotlinmvpbangundatar.R
import com.example.course3kotlinmvpbangundatar.model.Hasil
import com.example.course3kotlinmvpbangundatar.presenter.PersegiPanjangPresenter
import com.example.course3kotlinmvpbangundatar.presenter.PersegiPanjangView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), PersegiPanjangView {


    private var presenter : PersegiPanjangPresenter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter = PersegiPanjangPresenter(this)

        btnCalculate.setOnClickListener {
            val panjang = edInput1.text.toString()
            val lebar = edInput2.text.toString()

            presenter?.hitung(panjang, lebar)
        }
    }

    override fun hasilHitung(hasil: Hasil) {
        TODO("Not yet implemented")
        Toast.makeText(this, hasil.total.toString(), Toast.LENGTH_SHORT).show()
    }
}