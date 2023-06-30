package br.com.exactaworks.exactabank.facade.impl

import br.com.exactaworks.exactabank.controller.request.AccountDepositoRequest
import br.com.exactaworks.exactabank.controller.response.AccountDepositoResponse
import br.com.exactaworks.exactabank.enums.CategoriaEnum
import br.com.exactaworks.exactabank.exception.BadRequestException
import br.com.exactaworks.exactabank.facade.AccountTransactionFacade
import br.com.exactaworks.exactabank.mapper.AccountMapper
import br.com.exactaworks.exactabank.service.AccountService
import org.springframework.stereotype.Service

@Service
class AccountTransactionFacadeImpl(
    private val accountService: AccountService,
    private val accountMapper: AccountMapper
): AccountTransactionFacade {

    override fun depositSwitch(
        accountNumber: String?,
        email: String?,
        cpf: String?,
        accountDepositoRequest: AccountDepositoRequest
    ): AccountDepositoResponse {
        // TODO verificar se conta existe
        return if (!accountNumber.isNullOrEmpty() && (email.isNullOrEmpty() && cpf.isNullOrEmpty())) {
            deposito(accountNumber, accountDepositoRequest)
        } else if (!email.isNullOrEmpty()) {
            pix(email, "email", accountDepositoRequest)
        } else if (!cpf.isNullOrEmpty()) {
            pix(cpf, "cpf", accountDepositoRequest)
        } else {
            throw BadRequestException("Nenhum documento foi informado")
        }
    }

    fun deposito(accountNumber: String, accountDepositoRequest: AccountDepositoRequest): AccountDepositoResponse {

        val account = accountService.findByAccountNumber(accountNumber)

        if (accountDepositoRequest.password != account.password) {
            return throw BadRequestException("senha inválida")
        }

        if (accountDepositoRequest.valor > 0) {
            account.balance += accountDepositoRequest.valor

            accountService.save(account)
        }

        return accountMapper.accountDepositoRequestToAccountDepositoResponse(accountNumber, account.balance, accountDepositoRequest.valor, CategoriaEnum.DEPOSITO)
    }

    fun pix(documento: String, tipoPix: String, accountDepositoRequest: AccountDepositoRequest): AccountDepositoResponse {

        val account = if (tipoPix == "email") {
            accountService.findByEmail(documento)
        } else {
            accountService.findByCpf(documento)
        }

        if (accountDepositoRequest.password != account.password) {
            return throw BadRequestException("senha inválida")
        }

        if (accountDepositoRequest.valor > 0) {
            account.balance += accountDepositoRequest.valor

            accountService.save(account)
        }

        return accountMapper.accountDepositoRequestToAccountDepositoResponse(documento, account.balance, accountDepositoRequest.valor, CategoriaEnum.PIX)
    }
}