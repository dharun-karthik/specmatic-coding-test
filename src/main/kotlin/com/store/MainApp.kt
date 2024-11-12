package com.store

import com.store.config.StringToProductTypeConverter
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.format.FormatterRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@SpringBootApplication
open class Application : WebMvcConfigurer {
    override fun addFormatters(registry: FormatterRegistry) {
        registry.addConverter(StringToProductTypeConverter())
    }
}

fun main(args: Array<String>) {
    runApplication<Application>(*args)
}