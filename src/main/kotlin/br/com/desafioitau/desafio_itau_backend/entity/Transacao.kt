package br.com.desafioitau.desafio_itau_backend.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import java.math.BigDecimal
import java.time.OffsetDateTime
import java.time.OffsetTime
import java.util.UUID

@Entity(name = "transacao")
data class Transacao(

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private val id: UUID,
    private val valor: BigDecimal,
    private val dataHora: OffsetDateTime

)
