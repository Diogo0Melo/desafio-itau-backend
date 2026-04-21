package br.com.desafioitau.desafio_itau_backend.mapper

interface IMapper<T, U, V> {

    fun requestToEntity(dto: T): U
    fun entityToResponse(entity: U): V

}