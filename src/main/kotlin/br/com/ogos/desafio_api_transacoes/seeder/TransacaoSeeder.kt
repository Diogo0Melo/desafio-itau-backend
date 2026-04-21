package br.com.ogos.desafio_api_transacoes.seeder

import br.com.ogos.desafio_api_transacoes.entity.TransacaoEntity
import br.com.ogos.desafio_api_transacoes.repository.IRepository
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