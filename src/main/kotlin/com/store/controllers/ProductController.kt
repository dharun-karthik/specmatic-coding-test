package com.store.controllers

import com.store.config.ProductList
import com.store.constants.ProductType
import com.store.entity.Product
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/products")
class ProductController(private val productList: ProductList) {

    @GetMapping
    fun getProducts(@RequestParam(required = false) type: ProductType?): ResponseEntity<List<Product>> {
        val products = productList.getProducts(type)
        return ResponseEntity(products, HttpStatus.OK)
    }

    @PostMapping
    fun addProducts(): ResponseEntity<Any> {
        return ResponseEntity(HttpStatus.CREATED)
    }

}
