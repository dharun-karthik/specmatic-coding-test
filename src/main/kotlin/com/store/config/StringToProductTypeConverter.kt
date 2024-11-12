package com.store.config

import com.store.constants.ProductType
import org.springframework.core.convert.converter.Converter
import org.springframework.stereotype.Component

@Component
class StringToProductTypeConverter : Converter<String, ProductType> {
    override fun convert(source: String): ProductType {
        return ProductType.entries.find { it.name.equals(source, ignoreCase = true) }
            ?: throw IllegalArgumentException("Invalid product type: $source")
    }
}