package br.edu.infnet.quemvotei

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class PerfilViewModel: ViewModel() {
    val nome = MutableLiveData<String>()
    val idade = MutableLiveData<String>()
    val cidade = MutableLiveData<String>()
    val status = MutableLiveData<String>()

    init {
        idade.observeForever {
            if (it != null){
                status.value = when(deveVotar(it.toInt())){
                    FACULTATIVO -> "Seu voto será FACULTATIVO na próxima eleição"
                    OBRIGATORIO -> "Seu voto será OBRIGATÓRIO na próxima eleição"
                    else -> "Menor de 16? Como veio parar aqui?"
                }
            }

        }
    }
}