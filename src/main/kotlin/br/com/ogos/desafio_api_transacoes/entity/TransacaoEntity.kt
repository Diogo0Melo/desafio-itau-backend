package br.com.ogos.desafio_api_transacoes.entity

import jakarta.persistence.Entity
import jakarta.persistence.Id
import java.math.BigDecimal
import java.time.OffsetDateTime
import java.util.UUID

@Entity(name = "transacao")
data class TransacaoEntity(
    @Id
    val id: UUID = UUID.randomUUID(),
    val valor: BigDecimal,
    val dataHora: OffsetDateTime
)
