package br.com.exactaworks.exactabank.mapper

import br.com.exactaworks.exactabank.controller.response.AccountDepositoResponse
import br.com.exactaworks.exactabank.controller.response.TransactionResponse
import br.com.exactaworks.exactabank.enums.CategoriaEnum
import br.com.exactaworks.exactabank.repository.entity.Transaction
import org.mapstruct.Mapper

@Mapper(componentModel = "spring")
interface TransactionMapper {

    fun transactionToTransactionResponse(transaction: Transaction): TransactionResponse

    fun toAccountDepositoResponse(documento: String, tipoDocumento: String, balance: Double, valor: Double, categoria: CategoriaEnum): AccountDepositoResponse
}