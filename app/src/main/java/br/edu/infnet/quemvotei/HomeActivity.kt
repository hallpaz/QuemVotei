package br.edu.infnet.quemvotei

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.activity_profile.*

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        configurarNavegacao()
    }

    private fun configurarNavegacao(){
        bottom_navigation_view.setupWithNavController(
            findNavController(R.id.host_fragment)
        )
    }

}
