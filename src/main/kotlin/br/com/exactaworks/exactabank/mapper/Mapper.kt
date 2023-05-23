package br.com.exactaworks.exactabank.mapper

interface Mapper<T, U> {

    fun map(t: T): U
}