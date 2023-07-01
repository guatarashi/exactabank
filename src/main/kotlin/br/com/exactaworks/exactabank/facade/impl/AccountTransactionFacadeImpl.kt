package br.com.exactaworks.exactabank.facade.impl

import br.com.exactaworks.exactabank.controller.request.AccountDepositoRequest
import br.com.exactaworks.exactabank.controller.response.AccountDepositoResponse
import br.com.exactaworks.exactabank.enums.CategoriaEnum
import br.com.exactaworks.exactabank.exception.BadRequestException
import br.com.exactaworks.exactabank.facade.AccountTransactionFacade
import br.com.exactaworks.exactabank.mapper.TransactionMapper
import br.com.exactaworks.exactabank.service.AccountService
import org.springframework.stereotype.Service

@Service
class AccountTransactionFacadeImpl(
    private val accountService: AccountService,
    private val transactionMapper: TransactionMapper
): AccountTransactionFacade {

    override fun depositSwitch(
        accountNumber: String?,
        email: String?,
        cpf: String?,
        accountDepositoRequest: AccountDepositoRequest
    ): AccountDepositoResponse {
        // TODO verificar se conta existe
        return if (!accountNumber.isNullOrEmpty() && (email.isNullOrEmpty() && cpf.isNullOrEmpty())) {
            deposito(accountNumber, "conta_corrente", accountDepositoRequest, CategoriaEnum.DEPOSITO)
        } else if (!email.isNullOrEmpty()) {
            deposito(email, "email", accountDepositoRequest, CategoriaEnum.PIX)
        } else if (!cpf.isNullOrEmpty()) {
            deposito(cpf, "cpf", accountDepositoRequest, CategoriaEnum.PIX)
        } else {
            throw BadRequestException("Nenhum documento foi informado")
        }
    }

    fun deposito(documento: String, tipoDocumento: String, accountDepositoRequest: AccountDepositoRequest, categoria: CategoriaEnum): AccountDepositoResponse {

        val account = when (tipoDocumento) {
            "conta_corrente" -> accountService.findByAccountNumber(documento)
            "email" -> accountService.findByEmail(documento)
            else -> accountService.findByCpf(documento)
        }

        if (accountDepositoRequest.password != account.password) {
            throw BadRequestException("senha inválida")
        }

        if (accountDepositoRequest.valor > 0) {
            account.balance += accountDepositoRequest.valor

            accountService.save(account)
        }

        return transactionMapper.toAccountDepositoResponse(documento, tipoDocumento, account.balance, accountDepositoRequest.valor, categoria)
    }
}