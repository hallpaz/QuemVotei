package br.edu.infnet.quemvotei


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.fragment_informacoes.*

/**
 * A simple [Fragment] subclass.
 */
class InformacoesFragment : Fragment() {

    private lateinit var cadastroViewModel: CadastroViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_informacoes, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity?.let {act->
            cadastroViewModel = ViewModelProviders.of(act)
                .get(CadastroViewModel::class.java)
        }
        subscribe()
    }

    private fun subscribe(){
        cadastroViewModel.nome.observe(this, Observer {
            if(it != null && it.isNotBlank()){
                pnome_textview.visibility = View.VISIBLE
                vnome_textview.visibility = View.VISIBLE
            } else {
                pnome_textview.visibility = View.GONE
                vnome_textview.visibility = View.GONE
            }
        })

        cadastroViewModel.idade.observe(this, Observer {
            if(it != null && it.isNotBlank()){
                pidade_textview.visibility = View.VISIBLE
                vidade_textview.visibility = View.VISIBLE
            } else {
                pidade_textview.visibility = View.GONE
                vidade_textview.visibility = View.GONE
            }
        })

        cadastroViewModel.local.observe(this, Observer {
            if(it != null && it.isNotBlank()){
                plocal_textview.visibility = View.VISIBLE
                vlocal_textview.visibility = View.VISIBLE
            } else {
                plocal_textview.visibility = View.GONE
                vlocal_textview.visibility = View.GONE
            }
        })

        cadastroViewModel.titulo.observe(this, Observer {
            if(it != null && it.isNotBlank()){
                ptitulo_textview.visibility = View.VISIBLE
                vtitulo_textview.visibility = View.VISIBLE
            } else {
                ptitulo_textview.visibility = View.GONE
                vtitulo_textview.visibility = View.GONE
            }
        })

        cadastroViewModel.zona.observe(this, Observer {
            if(it != null && it.isNotBlank()){
                pzona_textview.visibility = View.VISIBLE
                vzona_textview.visibility = View.VISIBLE
            } else {
                pzona_textview.visibility = View.GONE
                vzona_textview.visibility = View.GONE
            }
        })

        cadastroViewModel.secao.observe(this, Observer {
            if(it != null && it.isNotBlank()){
                psecao_textview.visibility = View.VISIBLE
                vsecao_textview.visibility = View.VISIBLE
            } else {
                psecao_textview.visibility = View.GONE
                vsecao_textview.visibility = View.GONE
            }
        })

    }


}
