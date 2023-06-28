package br.com.exactaworks.exactabank.exception

import java.lang.RuntimeException

class NotFoundException(message: String): RuntimeException(message) {
}