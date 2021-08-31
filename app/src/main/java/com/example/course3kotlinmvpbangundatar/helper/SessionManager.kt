package com.example.course3kotlinmvpbangundatar.helper

import android.content.Context
import android.content.SharedPreferences

class SessionManager(var c:Context) {
    var pref:SharedPreferences? = null;
    var editor:SharedPreferences.Editor? = null
    var PREF_NAME = "LOGINREGISTER"
    var ISLOGIN = "islogin"
    var NAME = "name"
    var EMAIL = "email"
    var HP = "hp"
    init{
        pref = c.getSharedPreferences(PREF_NAME, 0)
        editor = pref?.edit()
    }
    var login:Boolean?
        get() = pref?.getBoolean(ISLOGIN,false)
        set(login){
            editor?.putBoolean(ISLOGIN, true)
            editor?.commit()
        }
    var name:String?
        get() = pref?.getString(NAME,"")
        set(name){
            editor?.putString(NAME, name)
            editor?.commit()
        }
    var email:String?
        get() = pref?.getString(EMAIL,"")
        set(email){
            editor?.putString(EMAIL, email)
            editor?.commit()
        }
    var hp:String?
        get() = pref?.getString(HP,"")
        set(hp){
            editor?.putString(HP, hp)
            editor?.commit()
        }

    fun logout(){
        editor?.clear()
        editor?.commit()
    }
}