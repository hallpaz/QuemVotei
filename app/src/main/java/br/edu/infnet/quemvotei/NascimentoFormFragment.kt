package br.edu.infnet.quemvotei


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_nascimento_form.*

/**
 * A simple [Fragment] subclass.
 */
class NascimentoFormFragment : Fragment() {

    private lateinit var cadastroViewModel: CadastroViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_nascimento_form, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // A referência para o ViewModel deve ser a Activity
        // e não este fragmento. Precisaremos de uma referência
        // comum para podermos compartilhar a mesma instância
        // de ViewModel
        activity?.let {act->
            cadastroViewModel = ViewModelProviders.of(act)
                .get(CadastroViewModel::class.java)
        }
        setUpListeners()
    }

    private fun setUpListeners(){
        avancar_button.setOnClickListener {
            // modifica o valor da variável "nascimento" no ViewModel
            cadastroViewModel.nascimento = nascimento_edittext.text.toString()
            // Solicita navegação para o próximo fragmento
            findNavController().navigate(R.id.nome_form_dest)
        }
    }
}
