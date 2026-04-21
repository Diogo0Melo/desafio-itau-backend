package br.com.ogos.desafio_api_transacoes.mapper

interface IMapper<T, U, V> {

    fun requestToEntity(dto: T): U
    fun entityToResponse(entity: U): V

}