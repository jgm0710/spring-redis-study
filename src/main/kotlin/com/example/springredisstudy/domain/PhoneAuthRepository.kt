package com.example.springredisstudy.domain

interface PhoneAuthRepository {

    fun save(phoneAuth: PhoneAuth): PhoneAuth

    fun findByPhone(phone: String): PhoneAuth?
}
