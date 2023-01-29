package com.example.springredisstudy.application.command

data class ValidateAuthCodeCommand(val phone: String, val authCode: String) {
}
