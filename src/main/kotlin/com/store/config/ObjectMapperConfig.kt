package com.store.config

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonDeserializer
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.MapperFeature
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter
import java.io.IOException


@Configuration
open class ObjectMapperConfig {

    @Bean
    open fun mappingJackson2HttpMessageConverter(): MappingJackson2HttpMessageConverter {
        val builder = Jackson2ObjectMapperBuilder()
        builder.simpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
        builder.featuresToDisable(MapperFeature.ALLOW_COERCION_OF_SCALARS)
        builder.deserializerByType(String::class.java, DisableBooleanToString())
        return MappingJackson2HttpMessageConverter(builder.build())
    }

    class DisableBooleanToString : JsonDeserializer<String>() {
        @Throws(IOException::class)
        override fun deserialize(p: JsonParser, ctxt: DeserializationContext): String {
            val node = p.codec.readTree<JsonNode>(p)
            if (!node.isTextual) {
                throw IllegalArgumentException("Invalid input for name: Expected a String.")
            }
            return node.asText()
        }
    }
}