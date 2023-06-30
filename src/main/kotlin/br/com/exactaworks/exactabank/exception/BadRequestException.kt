package br.com.exactaworks.exactabank.exception

import java.lang.RuntimeException

class BadRequestException(message: String): RuntimeException(message) {
}