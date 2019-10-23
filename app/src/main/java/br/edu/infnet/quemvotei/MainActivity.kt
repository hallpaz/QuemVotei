package br.edu.infnet.quemvotei

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        next_button.setOnClickListener {
            //recebe a idade como uma String (texto)
            val idade = idade_edittext.text.toString()
            // passa a idade convertida para inteiro
            val status = deveVotar(idade.toInt())
            if (status == PROIBIDO){
                Toast.makeText(this,
                    "Você NÃO PODE usar este APP ainda!",
                    Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this,
                    "Vamos prosseguir com o seu perfil!",
                    Toast.LENGTH_LONG).show()
            }
        }
    }
}
