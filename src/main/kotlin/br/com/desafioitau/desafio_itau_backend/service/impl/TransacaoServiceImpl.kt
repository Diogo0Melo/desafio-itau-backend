package br.com.desafioitau.desafio_itau_backend.service.impl

import br.com.desafioitau.desafio_itau_backend.dto.request.TransacaoRequestDTO
import br.com.desafioitau.desafio_itau_backend.dto.response.TransacaoResponseDTO
import br.com.desafioitau.desafio_itau_backend.entity.TransacaoEntity
import br.com.desafioitau.desafio_itau_backend.mapper.ITransacaoMapper
import br.com.desafioitau.desafio_itau_backend.repository.ITransacaoRepository
import br.com.desafioitau.desafio_itau_backend.service.ITransacaoService
import org.springframework.stereotype.Service

@Service
class TransacaoServiceImpl(
    private val repository: ITransacaoRepository,
    private val mapper: ITransacaoMapper<TransacaoRequestDTO, TransacaoEntity, TransacaoResponseDTO>,
): ITransacaoService {
    override fun salvarTransacao(dto: TransacaoRequestDTO): TransacaoResponseDTO {
        val entidade = mapper.requestToEntity(dto)
        val entidadeSalva = repository.salvar(entidade)

        return mapper.entityToResponse(entidadeSalva)
    }
}