package br.edu.infnet.quemvotei

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    private lateinit var perfilViewModel: PerfilViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        perfilViewModel = ViewModelProviders.of(this)
                            .get(PerfilViewModel::class.java)
        recuperarDados()
        configurarNavegacao()
    }

    private fun configurarNavegacao(){
        bottom_navigation_view.setupWithNavController(
            findNavController(R.id.host_fragment)
        )
    }

    fun recuperarDados(){
        val nome = intent.getStringExtra(NOME_EXTRA)
        val cidade = intent.getStringExtra(CIDADE_EXTRA)
        val idade = intent.getStringExtra(IDADE_EXTRA)

        perfilViewModel.nome.value = nome
        perfilViewModel.idade.value = idade
        perfilViewModel.cidade.value = cidade
    }

}
