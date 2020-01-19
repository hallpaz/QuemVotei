package br.edu.infnet.quemvotei.eleicoes

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import br.edu.infnet.quemvotei.ANO_EXTRA
import br.edu.infnet.quemvotei.R
import br.edu.infnet.quemvotei.TIPO_EXTRA
import kotlinx.android.synthetic.main.activity_add_eleicao.*

class AddEleicaoActivity : AppCompatActivity() {

    var tipoEleicao:String = ""
    val tipos = listOf("Municipais", "Gerais", "Outros")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_eleicao)
        setUpListeners()
        setUpSpinner()
    }

    private fun setUpSpinner(){
        tipo_spinner.adapter = ArrayAdapter<String>(this,
            android.R.layout.simple_spinner_item,
            tipos)
    }

    private fun setUpListeners(){
        cadastrar_eleicao_button.setOnClickListener {
            // recupera o ano digitado
            val ano = ano_edittext.text.toString()
            if (ano.isNotBlank() && tipoEleicao.isNotBlank()){
                //Cria uma intent para retorno
                val retornoIntent = Intent()
                // Adiciona a string em "ano" à intent
                retornoIntent.putExtra(ANO_EXTRA, ano)
                // Adiciona a string em "ano" à intent
                retornoIntent.putExtra(TIPO_EXTRA, tipoEleicao)
                // Confirma que a ação foi executada
                setResult(Activity.RESULT_OK, retornoIntent)
                // encerra esta Activity
                finish()
            } else {
                Toast.makeText(this,
                    "Por favor, preencha corretamente todos os campos",
                    Toast.LENGTH_LONG).show()
            }
        }

        tipo_spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(p0: AdapterView<*>?) {}

            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                tipoEleicao = tipos[p2]
            }

        }
    }
}
