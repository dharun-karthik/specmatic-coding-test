package com.store.config

import com.store.constants.ProductType
import com.store.entity.Product
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Component

@Component
@ConfigurationProperties(prefix = "product-list")
open class ProductList(var products: List<Product> = listOf()) {

    fun getProducts(type: ProductType? = null): List<Product> {
        return products.filter { type == null || it.type == type }
    }

    fun addProduct(product: Product) {
        products = products.plus(product)
    }

}