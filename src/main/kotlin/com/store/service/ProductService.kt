package com.store.service

import com.store.config.ProductList
import com.store.constants.ProductType
import com.store.entity.Product
import org.springframework.stereotype.Service

@Service
class ProductService(private val productList: ProductList) {

    fun getProducts(type: ProductType?): List<Product> {
        return productList.getProducts(type)
    }


}