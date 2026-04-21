package br.com.ogos.desafio_api_transacoes.controller


import br.com.ogos.desafio_api_transacoes.dto.request.TransacaoRequestDTO
import br.com.ogos.desafio_api_transacoes.dto.response.TransacaoResponseDTO
import br.com.ogos.desafio_api_transacoes.service.ITransacaoService
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/transacao")
class TransacaoController(
    private val service: ITransacaoService
) {

    @PostMapping
    fun cadastrar(@Valid @RequestBody dto: TransacaoRequestDTO): ResponseEntity<TransacaoResponseDTO> {
        val resultado = service.salvarTransacao(dto)

        return ResponseEntity.status(201).body(resultado)
    }

    @DeleteMapping
    fun deletarTudo(): ResponseEntity<String> {
        val resposta: Map<Map<String, Boolean>, Map<String, String>> = service.limpar()
        val resultado = resposta.keys.first().getValue("resultado")
        val mensagem = resposta.values.first().getValue("mensagem")

        return when (resultado) {
            true -> ResponseEntity.ok().body(mensagem)
            false -> ResponseEntity.badRequest().body(mensagem)
        }
    }
}