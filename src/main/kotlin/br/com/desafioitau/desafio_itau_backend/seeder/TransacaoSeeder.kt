package br.com.desafioitau.desafio_itau_backend.seeder

import br.com.desafioitau.desafio_itau_backend.entity.TransacaoEntity
import br.com.desafioitau.desafio_itau_backend.repository.IRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component
import java.time.OffsetDateTime
import kotlin.random.Random
import kotlin.random.nextInt

@Component
class TransacaoSeeder(
    private val repository: IRepository
) : CommandLineRunner {

    override fun run(vararg args: String?) {
        for (i in 0..999) {
            repository.salvar(
                TransacaoEntity(
                    valor = Random.nextInt(2..9999).toBigDecimal(),
                    dataHora = OffsetDateTime.now()
                )
            )
        }
    }
}