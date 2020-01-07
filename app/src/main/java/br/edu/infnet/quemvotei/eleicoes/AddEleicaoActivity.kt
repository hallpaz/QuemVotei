package br.edu.infnet.quemvotei.eleicoes

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.edu.infnet.quemvotei.ANO_EXTRA
import br.edu.infnet.quemvotei.R
import kotlinx.android.synthetic.main.activity_add_eleicao.*

class AddEleicaoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_eleicao)
        setUpListeners()
    }

    private fun setUpListeners(){
        cadastrar_eleicao_button.setOnClickListener {
            // recupera o ano digitado
            val ano = ano_edittext.text.toString()
            //Cria uma intent para retorno
            val retornoIntent = Intent()
            // Adiciona a string em "ano" à intent
            retornoIntent.putExtra(ANO_EXTRA, ano)
            // Confirma que a ação foi executada
            setResult(Activity.RESULT_OK, retornoIntent)
            // encerra esta Activity
            finish()
        }
    }
}
