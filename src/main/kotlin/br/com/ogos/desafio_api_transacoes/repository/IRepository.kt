package br.com.ogos.desafio_api_transacoes.repository

import br.com.ogos.desafio_api_transacoes.entity.TransacaoEntity


interface IRepository {

    fun salvar(transacao: TransacaoEntity): TransacaoEntity
    fun limpar(): Boolean
    fun buscar(): List<TransacaoEntity>

}