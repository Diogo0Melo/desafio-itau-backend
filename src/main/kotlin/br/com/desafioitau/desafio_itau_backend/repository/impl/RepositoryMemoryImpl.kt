package br.com.desafioitau.desafio_itau_backend.repository.impl

import br.com.desafioitau.desafio_itau_backend.entity.TransacaoEntity
import br.com.desafioitau.desafio_itau_backend.repository.IRepository
import org.springframework.stereotype.Repository
import java.time.OffsetDateTime

@Repository
class RepositoryMemoryImpl : IRepository {

    private val dados = mutableListOf<TransacaoEntity>()

    override fun salvar(transacao: TransacaoEntity): TransacaoEntity {
        dados.add(transacao)
        return transacao
    }

    override fun limpar(): Boolean {
        dados.clear()
        return dados.isEmpty()
    }

    override fun buscar(): List<TransacaoEntity> {
        val dataHoraAtual = OffsetDateTime.now()
        val transacoes = dados.filter { dataHoraAtual.minusSeconds(60).isBefore(it.dataHora) }
        return transacoes
    }
}