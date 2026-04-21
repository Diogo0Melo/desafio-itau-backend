package br.com.ogos.desafio_api_transacoes.controller

import br.com.ogos.desafio_api_transacoes.dto.response.EstatisticaResponseDTO
import br.com.ogos.desafio_api_transacoes.service.IEstatisticaService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/estatistica")
class EstatisticaController(
    private val service: IEstatisticaService
) {

    @GetMapping
    fun gerarEstatiticas(): ResponseEntity<EstatisticaResponseDTO> {
        val resposta = service.calcularEstatisticas()
        return ResponseEntity.ok().body(resposta)
    }
}