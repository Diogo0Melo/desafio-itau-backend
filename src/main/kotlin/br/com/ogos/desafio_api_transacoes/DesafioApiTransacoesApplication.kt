package br.com.ogos.desafio_api_transacoes

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/")
@SpringBootApplication(exclude = [DataSourceAutoConfiguration::class])
class DesafioApiTransacoesApplication() {

    @GetMapping
    fun running(): String {
        return "API is running"
    }
}

fun main(args: Array<String>) {
    runApplication<DesafioApiTransacoesApplication>(*args)
}
