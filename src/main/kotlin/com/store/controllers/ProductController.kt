package com.store.controllers

import com.store.config.ProductList
import com.store.entity.Product
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/products")
class ProductController(private val productList: ProductList) {

    @GetMapping
    fun getProducts(): ResponseEntity<List<Product>> {
        val products = productList.products
        return ResponseEntity(products, HttpStatus.OK)
    }

    @PostMapping
    fun addProducts(): ResponseEntity<Any> {
        return ResponseEntity(HttpStatus.CREATED)
    }

}
