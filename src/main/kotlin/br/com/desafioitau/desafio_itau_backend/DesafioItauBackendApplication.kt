package br.com.desafioitau.desafio_itau_backend

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.RestController

@RestController
@SpringBootApplication
class DesafioItauBackendApplication{


}

fun main(args: Array<String>) {
	runApplication<DesafioItauBackendApplication>(*args)
}
