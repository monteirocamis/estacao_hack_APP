package com.camismonteiro.estacaohack

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        //executando click no botao entrar
        btnLoginEntrar.setOnClickListener {
            //capturar dados digitados pelo usuario
            val email = edtLoginEmail.text.toString().trim().toLowerCase()
            val senha = edtLoginSenha.text.toString().trim()

            //validacao dos campos
            if (email.isEmpty()) {
                edtLoginEmail.error = "Campo obrigatório"
                edtLoginEmail.requestFocus()
            }else if (senha.isEmpty()){
                edtLoginSenha.error = "Campos obrigatorio!"
                edtLoginSenha.requestFocus()
            }else{
                //apresentar msg de erro ao usuario
                Toast.makeText(this,"email ou senha invalidos", Toast.LENGTH_LONG).show()
            }
        }
        //executando o click do botao cadastrar
        btnLoginCadastrar.setOnClickListener {
            //abrindo a tela de cadastro
            val mIntent = Intent(this,CadastroActivity::class.java)
            startActivity(mIntent)
        }

    }
}