package com.example.course3kotlinmvpbangundatar.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.course3kotlinmvpbangundatar.R
import com.example.course3kotlinmvpbangundatar.model.Kalkulator
import com.example.course3kotlinmvpbangundatar.presenter.KalkulatorPresenter
import com.example.course3kotlinmvpbangundatar.presenter.KalkulatorView
import kotlinx.android.synthetic.main.activity_kalkulator.*

class KalkulatorActivity : AppCompatActivity(), KalkulatorView {

    private var presenter : KalkulatorPresenter?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kalkulator)
        presenter = KalkulatorPresenter(this)

        btnKali.setOnClickListener {
            val nilai1 = edInput1.text.toString()
            val nilai2 = edInput2.text.toString()
            presenter?.hitungCalculator(nilai1, nilai2, "*")
        }
        btnBagi.setOnClickListener {
            val nilai1 = edInput1.text.toString()
            val nilai2 = edInput2.text.toString()
            presenter?.hitungCalculator(nilai1, nilai2, "/")
        }
        btnTambah.setOnClickListener {
            val nilai1 = edInput1.text.toString()
            val nilai2 = edInput2.text.toString()
            presenter?.hitungCalculator(nilai1, nilai2, "+")
        }
        btnKurang.setOnClickListener {
            val nilai1 = edInput1.text.toString()
            val nilai2 = edInput2.text.toString()
            presenter?.hitungCalculator(nilai1, nilai2, "-")
        }
    }

    override fun bindView(kal: Kalkulator) {
        Toast.makeText(this, "hasil total ${kal.total}", Toast.LENGTH_LONG).show()
    }

    override fun isEmpty() {
        Toast.makeText(this, "Field tidak boleh kosong", Toast.LENGTH_LONG).show()
    }
}