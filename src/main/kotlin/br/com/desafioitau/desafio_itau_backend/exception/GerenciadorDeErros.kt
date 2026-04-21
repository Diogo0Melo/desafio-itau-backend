package br.com.desafioitau.desafio_itau_backend.exception

import org.springframework.http.ResponseEntity
import org.springframework.http.converter.HttpMessageNotReadableException
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class GerenciadorDeErros {

    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun tratarErro422(ex: MethodArgumentNotValidException): ResponseEntity<List<DadosErroValidacao>> {
        val erros = ex.bindingResult.fieldErrors.map { erro ->
            DadosErroValidacao(erro.field, erro.defaultMessage ?: "Erro inválido")
        }
        return ResponseEntity.status(422).body(erros)
    }

    @ExceptionHandler(HttpMessageNotReadableException::class)
    fun tratarErro400(ex: HttpMessageNotReadableException): ResponseEntity<Any> {
        val erro = DadosErroValidacao(campo = "JSON", mensagem = "Corpo da requisição ausente ou JSON malformado")
        return ResponseEntity.badRequest().body(erro)
    }

    data class DadosErroValidacao(val campo: String, val mensagem: String)
}