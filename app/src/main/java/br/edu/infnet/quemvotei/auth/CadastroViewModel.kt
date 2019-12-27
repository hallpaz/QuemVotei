package br.edu.infnet.quemvotei.auth

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.edu.infnet.quemvotei.dataPraIdade
import br.edu.infnet.quemvotei.textoPraData

class CadastroViewModel: ViewModel() {
    val nome = MutableLiveData<String>().apply { value = "" }
    val idade = MutableLiveData<String>().apply { value = "" }
    val titulo = MutableLiveData<String>().apply { value = "" }
    val zona = MutableLiveData<String>().apply { value = "" }
    val secao = MutableLiveData<String>().apply { value = "" }
    val local = MutableLiveData<String>().apply { value = "" }
    var nascimento: String = ""
    set(value) {
        //podemos validar o valor se quisermos
        val data = textoPraData(value)
        idade.value = dataPraIdade(data).toString()
        // atribui o novo valor à variável
        field = value
    }
}