package br.com.ogos.desafio_api_transacoes.dto.response

import java.math.BigDecimal
import java.time.OffsetDateTime
import java.util.UUID

data class TransacaoResponseDTO(
    val id: UUID,
    val valor: BigDecimal,
    val dataHora: OffsetDateTime
)