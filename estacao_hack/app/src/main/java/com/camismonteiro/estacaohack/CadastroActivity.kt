package com.camismonteiro.estacaohack

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_cadastro.*

class CadastroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)
        //criando uma lista de opcoes para o spinner
        val listaGenero = arrayListOf("Selecione o gênero", "Feminino", "Masculino ", "outros")
        //criando um adaptador para a lista e o spinner
        val generoAdapter = ArrayAdapter(
            this,android.R.layout.simple_spinner_dropdown_item,listaGenero
         )
        //linkar o adaptador no spinner
        spnCadastroGenero.adapter = generoAdapter
        //executando o clique do cadastrar
        btnCadastroCadastrar.setOnClickListener {
            val nome = edtCadastroNome.text.toString().trim()
            val sobrenome = edtCadastroSobrenome.text.toString().trim()
            val email = edtCadastroEmail.text.toString().trim().toLowerCase()
            val senha = edtCadastroSenha.text.toString().trim()
            val genero = spnCadastroGenero.selectedItem.toString()
            //validacao dos campos
            if(nome.isEmpty() || sobrenome.isEmpty() || email.isEmpty() ||
                senha.isEmpty() || genero == listaGenero[0]){
                //apresentar uma mensagem de erro
                Toast.makeText(this,"Preencha todos os campos!" ,
                    Toast.LENGTH_LONG).show()
            }
            else{
                //se todos os campos foram preenchidos
                //criando/acessando o arquivo de preferencias compartilhadas
                val sharedPrefs = getSharedPreferences("cadastro_$email",
                    Context.MODE_PRIVATE)
                //editar o arquivo de preferencias compartilhadas
                val editPrefs = sharedPrefs.edit()
                //preparando os dados a serem salvos no arquivo
                editPrefs.putString("NOME", nome)
                editPrefs.putString("SOBRENOME", sobrenome)
                editPrefs.putString("EMAIL", email)
                editPrefs.putString("SENHA", senha)
                editPrefs.putString("GENERO", genero)
                //salvando os dados no arquvio shared preference
                editPrefs.apply()
                //abrindo a mainactivity
                val mIntent  = Intent(this, MainActivity::class.java)
                //passando informacoes entre telas da intent
                mIntent.putExtra("INTENT_EMAIL", email)
                startActivity(mIntent)
                //tirando todas as telas do empilhamento
                finishAffinity()
            }
        }


    }
}