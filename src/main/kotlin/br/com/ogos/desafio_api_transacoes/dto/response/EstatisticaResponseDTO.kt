package br.com.ogos.desafio_api_transacoes.dto.response

import java.math.BigDecimal

data class EstatisticaResponseDTO(
    val count: Long = 0,
    val sum: BigDecimal = BigDecimal.ZERO,
    val avg: BigDecimal = BigDecimal.ZERO,
    val min: BigDecimal = BigDecimal.ZERO,
    val max: BigDecimal = BigDecimal.ZERO
)