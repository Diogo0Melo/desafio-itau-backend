package br.com.desafioitau.desafio_itau_backend.service

import br.com.desafioitau.desafio_itau_backend.dto.request.TransacaoRequestDTO
import br.com.desafioitau.desafio_itau_backend.dto.response.TransacaoResponseDTO

interface ITransacaoService {
    fun salvarTransacao(dto: TransacaoRequestDTO): TransacaoResponseDTO
}