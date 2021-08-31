package com.example.course3kotlinmvpbangundatar.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.course3kotlinmvpbangundatar.R
import com.example.course3kotlinmvpbangundatar.helper.SessionManager
import com.example.course3kotlinmvpbangundatar.model.gsonSignin.DataItem
import com.example.course3kotlinmvpbangundatar.presenter.LoginPresenter
import com.example.course3kotlinmvpbangundatar.presenter.LoginView
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(), LoginView {

    private var presenter : LoginPresenter?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        presenter = LoginPresenter(this)

        btnSignin.setOnClickListener {
            val email = login_txtEmail.text.toString()
            val password = login_txtPassword.text.toString()
            presenter?.login(email, password)
        }
        signUp.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }
    }

    override fun loginSuccess(msg: String, user: List<DataItem>) {
        val session = SessionManager(this)
        session.email = user.get(0)?.userEmail
        session.hp = user.get(0)?.userHp
        session.name = user.get(0)?.userNama
        session.login = true
        startActivity(Intent(this, DashboardActivity::class.java))
        finish()
    }

    override fun statusMsgRegister(msg: String) {
        showToast(msg)
    }

    fun showToast(msg:String){
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
    }
}