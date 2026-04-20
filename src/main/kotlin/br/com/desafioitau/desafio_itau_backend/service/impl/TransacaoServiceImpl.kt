package br.com.desafioitau.desafio_itau_backend.service.impl

import br.com.desafioitau.desafio_itau_backend.dto.TransacaoRequestDTO
import br.com.desafioitau.desafio_itau_backend.dto.TransacaoResponseDTO
import br.com.desafioitau.desafio_itau_backend.entity.TransacaoEntity
import br.com.desafioitau.desafio_itau_backend.repository.ITransacaoRepository
import br.com.desafioitau.desafio_itau_backend.service.ITransacaoService
import org.springframework.stereotype.Service

@Service
class TransacaoServiceImpl(
    private val repository: ITransacaoRepository
): ITransacaoService {
    override fun salvarTransacao(dto: TransacaoRequestDTO): TransacaoResponseDTO {
        val entidade = TransacaoEntity(
            valor = dto.valor,
            dataHora = dto.dataHora,
        )
        val entidadeSalva = repository.salvar(entidade)

        return TransacaoResponseDTO(entidadeSalva.id, entidadeSalva.valor, entidadeSalva.dataHora)
    }
}