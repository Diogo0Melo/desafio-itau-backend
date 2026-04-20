package br.com.desafioitau.desafio_itau_backend.service

import br.com.desafioitau.desafio_itau_backend.dto.TransacaoRequestDTO
import br.com.desafioitau.desafio_itau_backend.dto.TransacaoResponseDTO

interface ITransacaoService {
    fun salvarTransacao(dto: TransacaoRequestDTO): TransacaoResponseDTO
}