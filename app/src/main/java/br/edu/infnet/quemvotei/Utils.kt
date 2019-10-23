package br.edu.infnet.quemvotei

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