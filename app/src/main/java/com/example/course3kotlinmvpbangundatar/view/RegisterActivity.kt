package com.example.course3kotlinmvpbangundatar.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Toast
import com.example.course3kotlinmvpbangundatar.R
import com.example.course3kotlinmvpbangundatar.model.register.RegisterResponse
import com.example.course3kotlinmvpbangundatar.presenter.RegisterPresenter
import com.example.course3kotlinmvpbangundatar.presenter.RegisterView
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity(), RegisterView {
    private var presenter:RegisterPresenter? = null;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        presenter = RegisterPresenter((this))
        btnSignUp.setOnClickListener {
            login_progress.visibility = View.VISIBLE
            Handler().postDelayed({
                val nama = eNama.text.toString()
                val noHp = eTelepon.text.toString()
                val email = eEmail.text.toString()
                val password = ePassword.text.toString()
                val passwordConf = ePasswordConfirm.text.toString()
                if(password.equals(passwordConf)){
                    presenter?.register(nama, noHp, email, password)
                }else{
                    showToast("Password and password confirm not match")
                }
            },3000)
        }
    }

    override fun successRegister(response: RegisterResponse) {
        if(response.isSuccess==false){
            showToast("Gagal registrasi ${response.message}")
        }else{
            startActivity(Intent(this, LoginActivity::class.java))
        }
    }

    override fun statusMsgRegister(msg: String) {
        showToast(msg)
    }

    override fun emptyData() {
        showToast("Tidak boleh ada yang kosong")
    }

    override fun startProgressBarr() {
        login_progress.visibility = View.VISIBLE
    }

    override fun stopProgressBarr() {
        login_progress.visibility = View.GONE
    }

    fun showToast(msg:String){
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
    }
}