package br.edu.infnet.quemvotei.eleicoes

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.edu.infnet.quemvotei.eleicoes.modelos.Eleicao

class EleicaoViewModel: ViewModel() {
    // Lista de dados para RecyclerView
    val eleicoes = MutableLiveData<List<Eleicao>>()
}