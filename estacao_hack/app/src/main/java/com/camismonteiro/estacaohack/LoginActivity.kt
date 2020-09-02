package com.camismonteiro.estacaohack

import android.content.Context
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
                //acessando o arquivo de preferencias compartilhadas
                val sharedPrefs = getSharedPreferences("cadastro_$email", Context.MODE_PRIVATE)
                //recuperando dados no arquivo shared preference
                val emailPrefs = sharedPrefs.getString("EMAIL", "" ) // se nao achar nda retorna vazio
                val senhaPrefs = sharedPrefs.getString("SENHA" , "")
                //verificando o email e senha que o usuarios colocou
                if (email == emailPrefs && senha == senhaPrefs){
                    Toast.makeText(this, "usuario logado!", Toast.LENGTH_LONG).show()
                    //abrindo a main activity
                    val mIntent = Intent(this, MainActivity::class.java)
                    //passando informacoes atraves da intent
                    mIntent.putExtra("INTENT_EMAIL", email)
                    startActivity(mIntent)
                    finish()
                }else{
                    //apresentar msg de erro ao usuario
                    Toast.makeText(this, "email ou senha invalidos!",
                        Toast.LENGTH_LONG).show()
                }
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