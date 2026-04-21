package br.com.desafioitau.desafio_itau_backend.repository.impl

import br.com.desafioitau.desafio_itau_backend.entity.TransacaoEntity
import br.com.desafioitau.desafio_itau_backend.repository.ITransacaoRepository
import org.springframework.stereotype.Repository

@Repository
class TransacaoRepositoryMemoryImpl: ITransacaoRepository {

    private val dados = mutableListOf<TransacaoEntity>()

    override fun salvar(transacao: TransacaoEntity): TransacaoEntity {
        dados.add(transacao)
        return transacao
    }

    override fun limpar(): Boolean {
        dados.clear()
        return dados.isEmpty()
    }

    override fun buscarTodos(): List<TransacaoEntity> = dados.toList()

    override fun buscarPorId(id: Long): TransacaoEntity? {
        TODO()
    }


}