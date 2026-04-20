package br.com.desafioitau.desafio_itau_backend.repository

import org.springframework.stereotype.Repository

@Repository
class TransacaoRepository {

    private val dados = mutableListOf<String>()

    fun salvar(transacao: String){
        dados.add(transacao)
    }

    fun buscarTodos(): List<String>{
        return dados.toList()
    }
}