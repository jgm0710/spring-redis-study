package com.example.springredisstudy.domain

interface PhoneAuthRepository {

    fun save(phoneAuth: PhoneAuth): PhoneAuth
}
