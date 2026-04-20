package br.com.desafioitau.desafio_itau_backend.controller

import br.com.desafioitau.desafio_itau_backend.entity.Transacao
import br.com.desafioitau.desafio_itau_backend.repository.TransacaoRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/transacao")
class TransacaoController
@Autowired constructor(
    private val repository: TransacaoRepository
) {

    @PostMapping("/criar")
    fun criar(@RequestBody transacao: String): String {
        repository.salvar(transacao)
        return transacao
    }
}