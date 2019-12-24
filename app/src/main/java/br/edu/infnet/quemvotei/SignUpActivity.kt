package br.edu.infnet.quemvotei

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_sign_up.*

// Activity de cadastro
class SignUpActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        val idade = intent.getStringExtra(IDADE_EXTRA)
        idade_textview.text = "$idade anos"
        setUpListeners()
    }

    private fun setUpListeners(){
        cadastrar_button.setOnClickListener {
            // Mais tarde validaremos as informações
            val nome = nome_edittext.text.toString()
            val cidade = cidade_edittext.text.toString()

            val profileIntent = Intent(this, HomeActivity::class.java)
            profileIntent.putExtra(NOME_EXTRA, nome)
            profileIntent.putExtra(CIDADE_EXTRA, cidade)
            profileIntent.putExtra(IDADE_EXTRA, intent.getStringExtra(IDADE_EXTRA))

            startActivity(profileIntent)
        }
    }
}
