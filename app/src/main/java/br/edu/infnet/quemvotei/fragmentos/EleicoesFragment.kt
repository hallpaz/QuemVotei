package br.edu.infnet.quemvotei.fragmentos


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager

import br.edu.infnet.quemvotei.R
import br.edu.infnet.quemvotei.eleicoes.EleicaoAdapter
import kotlinx.android.synthetic.main.fragment_eleicoes.*

/**
 * A simple [Fragment] subclass.
 */
class EleicoesFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_eleicoes, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        configurarRecyclerView()
    }

    private fun configurarRecyclerView(){
        lista_eleicoes.layoutManager = LinearLayoutManager(activity)
        lista_eleicoes.adapter = EleicaoAdapter()
        lista_eleicoes.addItemDecoration(
            DividerItemDecoration(activity, DividerItemDecoration.VERTICAL)
        )
    }
}
