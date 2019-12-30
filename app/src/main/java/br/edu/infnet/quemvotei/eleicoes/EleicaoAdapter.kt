package br.edu.infnet.quemvotei.eleicoes

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.edu.infnet.quemvotei.R


class EleicaoAdapter: RecyclerView.Adapter<EleicaoAdapter.EleicaoViewholder>() {

    val listaDeEleicoes = listOf("2018", "2016", "2014")

    // quantos itens serão exibidos na RecyclerView
    override fun getItemCount() = listaDeEleicoes.size

    // Executado poucas vezes, apenas no momento de criação
    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): EleicaoViewholder {
        val card = LayoutInflater
                    .from(parent.context)
                    .inflate(R.layout.eleicao_card, parent, false)
        return EleicaoViewholder(card)
    }

    // Pode ser executado muitas vezes, sempre que for necessário reconfigurar dados
    override fun onBindViewHolder(holder: EleicaoViewholder, position: Int) {
        holder.anoTextView.text = listaDeEleicoes[position]
    }

    class EleicaoViewholder(itemView: View):
        RecyclerView.ViewHolder(itemView){
        val anoTextView: TextView = itemView.findViewById(R.id.ano_textview)
    }
}