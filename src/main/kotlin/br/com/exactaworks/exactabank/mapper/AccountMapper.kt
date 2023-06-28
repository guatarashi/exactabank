package br.com.exactaworks.exactabank.mapper

import br.com.exactaworks.exactabank.controller.request.AccountRequest
import br.com.exactaworks.exactabank.controller.response.AccountResponse
import br.com.exactaworks.exactabank.repository.entity.Account
import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.Mappings

@Mapper(componentModel = "spring")
abstract class AccountMapper {

    @Mappings(
        Mapping(target = "id", expression = "java(java.util.UUID.randomUUID())"),
        Mapping(target = "accountNumber", expression = "java(generatedAccountNumber())")
        )
    abstract fun requestToAccount(accountRequest: AccountRequest): Account

    abstract fun accountToResponse(account: Account): AccountResponse

    fun generatedAccountNumber(): String {
        val allowedCharacters = ('A'..'Z')
        val allowedNumbers = ('0'..'9')

        val firstCharacter = allowedCharacters.random()
        val numbers = (1..4).map { allowedNumbers.random() }.joinToString("")
        val lastCharacter = allowedCharacters.random()

        return "$firstCharacter$numbers$lastCharacter"
    }
}