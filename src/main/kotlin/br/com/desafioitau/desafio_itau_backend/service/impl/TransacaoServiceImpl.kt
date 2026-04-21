package br.com.desafioitau.desafio_itau_backend.service.impl

import br.com.desafioitau.desafio_itau_backend.dto.request.TransacaoRequestDTO
import br.com.desafioitau.desafio_itau_backend.dto.response.TransacaoResponseDTO
import br.com.desafioitau.desafio_itau_backend.entity.TransacaoEntity
import br.com.desafioitau.desafio_itau_backend.mapper.IMapper
import br.com.desafioitau.desafio_itau_backend.repository.IRepository
import br.com.desafioitau.desafio_itau_backend.service.ITransacaoService
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