package br.com.desafioitau.desafio_itau_backend.repository

import br.com.desafioitau.desafio_itau_backend.entity.TransacaoEntity

interface IRepository {

    fun salvar(transacao: TransacaoEntity): TransacaoEntity
    fun limpar(): Boolean
    fun buscar(): List<TransacaoEntity>

}