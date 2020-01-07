package br.edu.infnet.quemvotei.eleicoes

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class EleicaoViewModel: ViewModel() {
    // Lista de dados para RecyclerView
    val eleicoes = MutableLiveData<List<String>>()
}