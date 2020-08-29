package com.camismonteiro.estacaohack

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        //é um dos metodos presentes no ciclo de vida da activity
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        //abri a mainActivity apos 5 segundos
        Handler(Looper.getMainLooper()).postDelayed({
            //iniciar uma intent - transicao da tela splash para a main
            val mIntent = Intent(this, LoginActivity::class.java)
            startActivity(mIntent)
            finish() // aparece 1x só
        }, 5000)
    }
}