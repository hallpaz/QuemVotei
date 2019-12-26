package br.edu.infnet.quemvotei.fragmentos


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import br.edu.infnet.quemvotei.PerfilViewModel

import br.edu.infnet.quemvotei.R
import kotlinx.android.synthetic.main.fragment_perfil.*

/**
 * A simple [Fragment] subclass.
 */
class PerfilFragment : Fragment() {

    private lateinit var perfilViewModel: PerfilViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_perfil, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity?.let {
            perfilViewModel = ViewModelProviders.of(it)
                                .get(PerfilViewModel::class.java)
        }
        subscribe()
    }

    private fun subscribe(){
        perfilViewModel.nome.observe(this, Observer {
            nome_textview.text = it ?: ""
        })

        perfilViewModel.idade.observe(this, Observer {
            idade_textview.text = it ?: ""
        })

        perfilViewModel.cidade.observe(this, Observer {
            cidade_textview.text = it ?: ""
        })

        perfilViewModel.status.observe(this, Observer {
            status_textview.text = it ?: ""
        })
    }


}
