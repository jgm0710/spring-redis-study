package com.example.springredisstudy.global.config

import com.example.springredisstudy.global.exception.AbstractHttpStatusException
import com.fasterxml.jackson.databind.Module
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import feign.Feign
import feign.FeignException
import feign.Response
import feign.codec.ErrorDecoder
import feign.form.FormEncoder
import feign.jackson.JacksonDecoder
import feign.okhttp.OkHttpClient
import org.slf4j.LoggerFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpStatus


@Configuration
class OrderFeignConfigFactory {

    private val log = LoggerFactory.getLogger(this::class.java)

    @Bean
    fun orderFeignConfig(): Feign.Builder? {
        return Feign.builder()
            .client(OkHttpClient())
            .encoder(FormEncoder())
            .decoder(JacksonDecoder(listOf<Module>(JavaTimeModule())))
            .errorDecoder(errorDecoder())
    }

    @Bean
    fun errorDecoder(): ErrorDecoder {
        return object : ErrorDecoder {
            override fun decode(methodKey: String?, response: Response): Exception {
                log.info("%s 요청이 성공하지 못했습니다. status : %s, body : %s", methodKey, response.status(), response.body())

                // 500 에러만 Exception 처리
                when (response.status()) {
                    in 500..511 -> handle5xxError(response)
                }

                return FeignException.errorStatus(methodKey, response)
            }

            private fun handle5xxError(response: Response): AbstractHttpStatusException {
                log.info(
                    ":::CustomErrorDecoder::: response: {} status : %s, body : %s",
                    response,
                    response.status(),
                    response.body()
                )
                return object :
                    AbstractHttpStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "feign client 500 error.") {
                }
            }
        }
    }
}
