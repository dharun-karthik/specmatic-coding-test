package com.store.service

import com.store.config.ProductList
import com.store.constants.ProductType
import com.store.dto.ProductCreateRequest
import com.store.entity.Product
import org.springframework.stereotype.Service

@Service
class ProductService(private val productList: ProductList) {

    fun getProducts(type: ProductType?): List<Product> {
        return productList.getProducts(type)
    }

    fun addProduct(product: ProductCreateRequest): Int {
        val generateId = generateId();
        productList.addProduct(Product(generateId, product.name, product.type, product.inventory))
        return generateId
    }

    private fun generateId(): Int {
        return (productList.getProducts().maxByOrNull { it.id }?.id ?: 0) + 1
    }

}