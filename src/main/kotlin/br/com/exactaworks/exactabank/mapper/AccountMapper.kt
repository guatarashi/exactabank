package br.com.exactaworks.exactabank.mapper

import br.com.exactaworks.exactabank.controller.request.AccountRequest
import br.com.exactaworks.exactabank.controller.response.AccountResponse
import br.com.exactaworks.exactabank.repository.entity.Account
import org.mapstruct.Mapper
import org.mapstruct.Mapping

@Mapper(componentModel = "spring")
interface AccountMapper {

    @Mapping(target = "id", expression = "java(java.util.UUID.randomUUID().toString())")
    fun requestToAccount(accountRequest: AccountRequest): Account

    fun accountToResponse(account: Account): AccountResponse
}