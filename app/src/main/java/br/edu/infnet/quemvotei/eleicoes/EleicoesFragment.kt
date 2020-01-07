package br.edu.infnet.quemvotei.eleicoes


import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import br.edu.infnet.quemvotei.ANO_EXTRA

import br.edu.infnet.quemvotei.R
import kotlinx.android.synthetic.main.fragment_eleicoes.*

/**
 * A simple [Fragment] subclass.
 */
class EleicoesFragment : Fragment() {

    // código de requisição para a ação "adicionar"
    private val ADD_REQUEST_CODE = 71
    private lateinit var eleicaoViewModel: EleicaoViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_eleicoes, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity?.let {
            eleicaoViewModel = ViewModelProviders.of(it)
                .get(EleicaoViewModel::class.java)
        }
        configurarRecyclerView()
        setUpListeners()
        subscribe()
    }

    private fun setUpListeners(){
        add_eleicao_fab.setOnClickListener {
            val addIntent = Intent(context, AddEleicaoActivity::class.java)
            // Inicia Activity esperando um dado no retorno
            startActivityForResult(addIntent, ADD_REQUEST_CODE)
        }
    }

    // Método chamado no retorno de "startActivityForResult"
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        // Verifica se a ação foi concretizada
        if (resultCode == Activity.RESULT_OK){
            // Verifica se o código de requisição é o esperado
            if (requestCode == ADD_REQUEST_CODE){
                // Se a intent "data" não for nula
                data?.let {
                    // lista já existente ou lista vazia
                    val lista = eleicaoViewModel.eleicoes.value ?: listOf()
                    // concatena novo elemento à lista
                    eleicaoViewModel.eleicoes.value =
                        lista + data.getStringExtra(ANO_EXTRA)
                }
            }
        }
    }

    private fun subscribe(){
        eleicaoViewModel.eleicoes.observe(this, Observer {lista->
            if (lista != null){
                // recupera o adapter da RecyclerView
                val adapter = lista_eleicoes.adapter
                // verifica se o adapter é uma instância de EleicaoAdapter
                if (adapter is EleicaoAdapter){
                    adapter.mudarDados(lista)
                }
            }
        })
    }

    private fun configurarRecyclerView(){
        // Define a forma da RecyclerView
        lista_eleicoes.layoutManager = LinearLayoutManager(activity)
        // Especifica do Adapter de dados
        lista_eleicoes.adapter = EleicaoAdapter()
        // Adicionar separedores entre os itens
        lista_eleicoes.addItemDecoration(
            DividerItemDecoration(activity, DividerItemDecoration.VERTICAL)
        )
    }
}
