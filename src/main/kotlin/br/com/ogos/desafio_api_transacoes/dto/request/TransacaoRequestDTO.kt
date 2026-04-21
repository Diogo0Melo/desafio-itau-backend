package br.com.ogos.desafio_api_transacoes.dto.request

import jakarta.validation.constraints.DecimalMin
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Past
import java.math.BigDecimal
import java.time.OffsetDateTime

data class TransacaoRequestDTO(

    @field:NotNull(message = "o campo valor não pode ser nulo")
    @field:DecimalMin(value = "0.0", inclusive = true, message = "o valor deve ser positivo")
    val valor: BigDecimal?,

    @field:NotNull(message = "o campo dataHora não pode ser nulo")
    @field:Past(message = "a data e hora da transação não pode ser futura")
    val dataHora: OffsetDateTime?
)