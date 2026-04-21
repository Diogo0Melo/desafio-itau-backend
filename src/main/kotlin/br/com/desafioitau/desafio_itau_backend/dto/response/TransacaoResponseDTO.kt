package br.com.desafioitau.desafio_itau_backend.dto.response

import java.math.BigDecimal
import java.time.OffsetDateTime
import java.util.UUID

data class TransacaoResponseDTO(
    val id: UUID,
    val valor: BigDecimal,
    val dataHora: OffsetDateTime
)