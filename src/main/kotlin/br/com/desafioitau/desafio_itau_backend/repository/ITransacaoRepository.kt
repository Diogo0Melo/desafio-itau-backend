package br.com.desafioitau.desafio_itau_backend.repository

import br.com.desafioitau.desafio_itau_backend.entity.TransacaoEntity

interface ITransacaoRepository {
    fun salvar(transacao: TransacaoEntity): TransacaoEntity
    fun buscarTodos(): List<TransacaoEntity>
    fun buscarPorId(id: Long): TransacaoEntity?
}