package br.edu.infnet.quemvotei

import java.text.SimpleDateFormat
import java.util.*

const val PROIBIDO = -1
const val FACULTATIVO = 0
const val OBRIGATORIO = 1

fun deveVotar(idade: Int): Int{
    when(idade) {
        in 18..69 -> return OBRIGATORIO
        in 0..15 -> return PROIBIDO
        else -> return FACULTATIVO
    }
}

fun textoPraData(texto: String): Date  =
    SimpleDateFormat("dd/MM/yyyy").parse(texto)

fun dataPraIdade(data: Date): Int {
    val a = Calendar.getInstance().apply {
        time = data
    }
    val b = Calendar.getInstance() //hoje
    var diff = b.get(Calendar.YEAR) - a.get(Calendar.YEAR)
    return if (a.get(Calendar.MONTH) > b.get(Calendar.MONTH) ||
        a.get(Calendar.MONTH) == b.get(Calendar.MONTH) &&
        a.get(Calendar.DATE) > b.get(Calendar.DATE)
    ) {
        --diff
    }else diff
}