package com.example.course3kotlinmvpbangundatar.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.course3kotlinmvpbangundatar.R
import com.example.course3kotlinmvpbangundatar.helper.SessionManager
import com.example.course3kotlinmvpbangundatar.view.DashboardActivity
import com.example.course3kotlinmvpbangundatar.view.LoginActivity
import com.example.course3kotlinmvpbangundatar.view.MainActivity

class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        val session = SessionManager(this)
        Handler().postDelayed(Runnable {
            if(session.login?:true){
                startActivity(Intent(this, DashboardActivity::class.java))
            }else{
                startActivity(Intent(this, LoginActivity::class.java))
            }
            finish()
        },2000)
    }
}