package com.example.springredisstudy.application

import com.example.springredisstudy.application.command.SendAuthCodeCommand
import com.example.springredisstudy.domain.PhoneAuth
import com.example.springredisstudy.domain.PhoneAuthRepository
import com.example.springredisstudy.domain.exception.PhoneAuthTooManyRequestException
import com.example.springredisstudy.domain.message.MessageSendService
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class PhoneAuthAplService(
    private val phoneAuthRepository: PhoneAuthRepository,
    private val messageSendService: MessageSendService,
) {

    @Transactional
    fun sendAuthCode(command: SendAuthCodeCommand): PhoneAuth {
        val existPhoneAuth: PhoneAuth? = phoneAuthRepository.findByPhone(phone = command.phone)

        val newPhoneAuth: PhoneAuth =
            if (existPhoneAuth == null) {
                PhoneAuth.createPhoneAuth(command.phone)
            } else {
                if (!existPhoneAuth.isTooManyRequest()) {
                    throw PhoneAuthTooManyRequestException()
                }
                existPhoneAuth.createNewPhoneAuth()
            }

        messageSendService.sendPhoneMessage(newPhoneAuth.phone, newPhoneAuth.authCodeMessage)

        return phoneAuthRepository.save(newPhoneAuth)
    }
}
