package br.com.desafioitau.desafio_itau_backend.dto

import java.math.BigDecimal
import java.time.OffsetDateTime

data class TransacaoRequestDTO(

    val valor: BigDecimal,
    val dataHora: OffsetDateTime

)
