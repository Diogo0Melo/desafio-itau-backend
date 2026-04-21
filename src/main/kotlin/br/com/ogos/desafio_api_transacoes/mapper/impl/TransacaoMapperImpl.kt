package br.com.ogos.desafio_api_transacoes.mapper.impl

import br.com.ogos.desafio_api_transacoes.dto.request.TransacaoRequestDTO
import br.com.ogos.desafio_api_transacoes.dto.response.TransacaoResponseDTO
import br.com.ogos.desafio_api_transacoes.entity.TransacaoEntity
import br.com.ogos.desafio_api_transacoes.mapper.IMapper
import org.springframework.stereotype.Component

@Component
class TransacaoMapperImpl : IMapper<TransacaoRequestDTO, TransacaoEntity, TransacaoResponseDTO> {
    override fun requestToEntity(dto: TransacaoRequestDTO): TransacaoEntity {
        return TransacaoEntity(
            valor = dto.valor!!,
            dataHora = dto.dataHora!!
        )
    }

    override fun entityToResponse(entity: TransacaoEntity): TransacaoResponseDTO {
        return TransacaoResponseDTO(
            id = entity.id,
            valor = entity.valor,
            dataHora = entity.dataHora
        )
    }
}