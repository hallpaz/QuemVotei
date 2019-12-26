package br.edu.infnet.quemvotei


import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_sign_up.*

/**
 * A simple [Fragment] subclass.
 */
class LocalFormFragment : Fragment() {

    private lateinit var cadastroViewModel: CadastroViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_local_form, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity?.let {act->
            cadastroViewModel = ViewModelProviders.of(act)
                .get(CadastroViewModel::class.java)
        }
        setUpListeners()
    }

    private fun setUpListeners(){
        // recuperar valores do ViewModel
        // caso sejam nulos, string vazia como valor padrão
        val nome = cadastroViewModel.nome.value ?: ""
        val idade = cadastroViewModel.idade.value ?: ""
        val local = cadastroViewModel.local.value ?: ""

        //Intent para iniciar HomeActivity
        val homeIntent = Intent(activity, HomeActivity::class.java)
        // adicionando dados informados
        homeIntent.putExtra(NOME_EXTRA, nome)
        homeIntent.putExtra(IDADE_EXTRA, idade)
        homeIntent.putExtra(CIDADE_EXTRA, local)
        startActivity(homeIntent)
    }

}
