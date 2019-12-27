package br.edu.infnet.quemvotei.auth


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import br.edu.infnet.quemvotei.R
import kotlinx.android.synthetic.main.fragment_nome_form.*

/**
 * A simple [Fragment] subclass.
 */
class NomeFormFragment : Fragment() {

    private lateinit var cadastroViewModel: CadastroViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_nome_form, container, false)
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
        avancar_button.setOnClickListener {
            cadastroViewModel.nome.value = nome_edittext.text.toString()
            findNavController().navigate(R.id.local_form_dest)
        }
    }
}
