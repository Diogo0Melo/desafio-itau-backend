package br.com.ogos.desafio_api_transacoes.service

import br.com.ogos.desafio_api_transacoes.dto.request.TransacaoRequestDTO
import br.com.ogos.desafio_api_transacoes.dto.response.TransacaoResponseDTO

interface ITransacaoService {

    fun salvarTransacao(dto: TransacaoRequestDTO): TransacaoResponseDTO
    fun limpar(): Map<Map<String, Boolean>, Map<String, String>>

}