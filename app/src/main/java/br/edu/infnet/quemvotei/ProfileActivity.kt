package br.edu.infnet.quemvotei

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_profile.*

class ProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        recuperarDados()
        configurarListeners()
    }

    fun recuperarDados(){
        val nome = intent.getStringExtra(NOME_EXTRA)
        val cidade = intent.getStringExtra(CIDADE_EXTRA)
        val idade = intent.getStringExtra(IDADE_EXTRA)

        nome_textview.text = nome
        cidade_textview.text = cidade
        idade_textview.text = idade

        status_textview.text = when(deveVotar(idade.toInt())){
            FACULTATIVO -> "Seu voto será FACULTATIVO na próxima eleição"
            OBRIGATORIO -> "Seu voto será OBRIGATÓRIO na próxima eleição"
            else -> "Menor de 16? Como veio parar aqui?"
        }
    }

    fun configurarListeners(){
//        discar_button.setOnClickListener {
//            val intent = Intent(Intent.ACTION_DIAL).apply {
//                data = Uri.parse("tel:$08006480005")
//            }
//            if (intent.resolveActivity(packageManager) != null) {
//                startActivity(intent)
//            }
//        }
    }
}
