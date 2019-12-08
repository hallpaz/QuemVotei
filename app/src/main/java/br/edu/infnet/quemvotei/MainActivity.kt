package br.edu.infnet.quemvotei

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val TAG = "QUEM VOTEI"
    override fun onCreate(savedInstanceState: Bundle?) {
        // Solicita que sejam realizadas as tarefas habituais de qualquer Activity
        // estas tarefas estão definidas na classe base da qual herdamos (AppCompatActivity)
        super.onCreate(savedInstanceState)
        // especifica o layout (forma/interface) desta Activity
        setContentView(R.layout.activity_main)

        // Adiciona uma função ao botão com id "avancar_button"
        avancar_button.setOnClickListener {
            //recebe a idade como uma String (texto)
            val idade = idade_edittext.text.toString()
            // limpa o campo de texto
            idade_edittext.setText("")
            // passa a idade convertida para inteiro
            val status = deveVotar(idade.toInt())
            // verifica a situação eleitoral do usuário e responde adequadamente
            if (status == PROIBIDO){
                Toast.makeText(this,
                    "Você NÃO PODE usar este APP ainda!",
                    Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this,
                    "Vamos prosseguir com o seu perfil!",
                    Toast.LENGTH_LONG).show()
            }
            // muda o texto escrito no botão
            avancar_button.text = "Apertou"
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG , "Entrou onStart")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG , "Entrou onRestart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG , "Entrou onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG , "Entrou onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG , "Entrou onStop")
    }

    override fun onDestroy() {
        Log.d(TAG , "Entrou onDestroy")
        super.onDestroy()
    }
}
