package br.com.ogos.desafio_api_transacoes.service

import br.com.ogos.desafio_api_transacoes.dto.response.EstatisticaResponseDTO

interface IEstatisticaService {

    fun calcularEstatisticas(): EstatisticaResponseDTO?

}