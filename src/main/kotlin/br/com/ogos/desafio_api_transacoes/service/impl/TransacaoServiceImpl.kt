package br.com.ogos.desafio_api_transacoes.service.impl

import br.com.ogos.desafio_api_transacoes.dto.request.TransacaoRequestDTO
import br.com.ogos.desafio_api_transacoes.dto.response.TransacaoResponseDTO
import br.com.ogos.desafio_api_transacoes.entity.TransacaoEntity
import br.com.ogos.desafio_api_transacoes.mapper.IMapper
import br.com.ogos.desafio_api_transacoes.repository.IRepository
import br.com.ogos.desafio_api_transacoes.service.ITransacaoService
import org.springframework.stereotype.Service

@Service
class TransacaoServiceImpl(
    private val repository: IRepository,
    private val mapper: IMapper<TransacaoRequestDTO, TransacaoEntity, TransacaoResponseDTO>,
) : ITransacaoService {
    override fun salvarTransacao(dto: TransacaoRequestDTO): TransacaoResponseDTO {
        val entidade = mapper.requestToEntity(dto)
        val entidadeSalva = repository.salvar(entidade)

        return mapper.entityToResponse(entidadeSalva)
    }

    override fun limpar(): Map<Map<String, Boolean>, Map<String, String>> {
        val resultado = repository.limpar()
        if (resultado)
            return mapOf(mapOf("resultado" to true) to mapOf("mensagem" to "Todos os dados foram apagados com sucesso"))
        return mapOf(mapOf("resultado" to false) to mapOf("mensagem" to "Ocorreu um erro ao deletar os dados"))
    }
}