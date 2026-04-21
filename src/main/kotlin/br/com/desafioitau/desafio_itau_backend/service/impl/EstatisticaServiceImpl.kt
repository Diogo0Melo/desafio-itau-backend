package br.com.desafioitau.desafio_itau_backend.service.impl

import br.com.desafioitau.desafio_itau_backend.dto.response.EstatisticaResponseDTO
import br.com.desafioitau.desafio_itau_backend.entity.TransacaoEntity
import br.com.desafioitau.desafio_itau_backend.repository.IRepository
import br.com.desafioitau.desafio_itau_backend.service.IEstatisticaService
import org.springframework.stereotype.Service
import java.math.BigDecimal

@Service
class EstatisticaServiceImpl(
    private val repository: IRepository
) : IEstatisticaService {
    override fun calcularEstatisticas(): EstatisticaResponseDTO? {
        val estatisticas = repository.buscar()
        if (estatisticas.isEmpty()) return EstatisticaResponseDTO()
        val count = getCount(estatisticas)
        val sum = getSum(estatisticas)
        val avg = getAvg(estatisticas, sum)
        val min = getMin(estatisticas)
        val max = getMax(estatisticas)
        return EstatisticaResponseDTO(count, sum, avg, min, max)
    }

    private fun getCount(estaticas: List<TransacaoEntity>): Long = estaticas.size.toLong()

    private fun getSum(estaticas: List<TransacaoEntity>): BigDecimal = estaticas.sumOf { it.valor }

    private fun getAvg(estaticas: List<TransacaoEntity>, sum: BigDecimal): BigDecimal =
        sum.divide(estaticas.size.toBigDecimal())

    private fun getMin(estaticas: List<TransacaoEntity>): BigDecimal = estaticas.minOf { it.valor }

    private fun getMax(estaticas: List<TransacaoEntity>): BigDecimal = estaticas.maxOf { it.valor }

}