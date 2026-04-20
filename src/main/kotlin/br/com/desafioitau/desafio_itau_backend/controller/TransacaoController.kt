package br.com.desafioitau.desafio_itau_backend.controller

import br.com.desafioitau.desafio_itau_backend.dto.TransacaoRequestDTO
import br.com.desafioitau.desafio_itau_backend.dto.TransacaoResponseDTO
import br.com.desafioitau.desafio_itau_backend.service.ITransacaoService
import br.com.desafioitau.desafio_itau_backend.service.impl.TransacaoServiceImpl
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/transacao")
class TransacaoController(
    private val service: ITransacaoService
) {

    @PostMapping("/criar")
    fun cadastrar(@RequestBody dto: TransacaoRequestDTO): ResponseEntity<TransacaoResponseDTO> {
        val resultado = service.salvarTransacao(dto)

        return ResponseEntity.status(201).body(resultado)
    }

    /*
     @GetMapping("/buscarTodos")
     fun buscarTodos(): String{
         return repository.buscarTodos().toString()
     }
     */
}