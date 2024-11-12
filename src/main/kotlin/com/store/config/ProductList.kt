package com.store.config

import com.store.entity.Product
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Component

@Component
@ConfigurationProperties(prefix = "product-list")
open class ProductList {
    var products: List<Product> = listOf()
}