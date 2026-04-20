package br.com.desafioitau.desafio_itau_backend

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@SpringBootApplication(exclude = [DataSourceAutoConfiguration::class])
class DesafioItauBackendApplication(){

    @RequestMapping("/")
    fun home(): String {
        return "API is running"
    }
}

fun main(args: Array<String>) {
	runApplication<DesafioItauBackendApplication>(*args)
}
