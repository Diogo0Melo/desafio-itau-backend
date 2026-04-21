package br.com.desafioitau.desafio_itau_backend.mapper.impl

import br.com.desafioitau.desafio_itau_backend.dto.request.TransacaoRequestDTO
import br.com.desafioitau.desafio_itau_backend.dto.response.TransacaoResponseDTO
import br.com.desafioitau.desafio_itau_backend.entity.TransacaoEntity
import br.com.desafioitau.desafio_itau_backend.mapper.IMapper
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