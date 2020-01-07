package br.edu.infnet.quemvotei.eleicoes

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.edu.infnet.quemvotei.R


class EleicaoAdapter(var listaDeEleicoes:List<String> = listOf())
        : RecyclerView.Adapter<EleicaoAdapter.EleicaoViewholder>() {

    // quantos itens serão exibidos na RecyclerView
    override fun getItemCount() = listaDeEleicoes.size

    // Executado poucas vezes, apenas no momento de criação
    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): EleicaoViewholder {
        // Lê o XML que define um item da lista
        // e obtém uma referência para ele
        val card = LayoutInflater
                    .from(parent.context)
                    .inflate(R.layout.eleicao_card, parent, false)
        return EleicaoViewholder(card)
    }

    // Pode ser executado muitas vezes,
    // sempre que for necessário reconfigurar dados
    override fun onBindViewHolder(holder: EleicaoViewholder, position: Int) {
        // configura o ano a partir do elemento
        // na posição correspondente da lista
        holder.anoTextView.text = listaDeEleicoes[position]
    }

    fun mudarDados(eleicoes: List<String>){
        // Modifica a lista de dados
        listaDeEleicoes = eleicoes
        // Solicita que a RecyclerView seja redesenhada
        notifyDataSetChanged()
    }

    class EleicaoViewholder(itemView: View):
        RecyclerView.ViewHolder(itemView){
        // Referência para a TextView que será
        // configurada com um ano da lista
        val anoTextView: TextView = itemView.findViewById(R.id.ano_textview)
    }
}