package br.com.desafioitau.desafio_itau_backend.service

import br.com.desafioitau.desafio_itau_backend.dto.response.EstatisticaResponseDTO

interface IEstatisticaService {

    fun calcularEstatisticas(): EstatisticaResponseDTO?

}