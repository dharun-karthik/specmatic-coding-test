package com.store.controllers

import com.store.entity.Product
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/products")
class ProductController {

    @GetMapping
    fun getProducts(): ResponseEntity<List<Product>> {
        return ResponseEntity(listOf(Product(1, "abc", "gadget", 2)), HttpStatus.OK)
    }

    @PostMapping
    fun addProducts(): ResponseEntity<Any> {
        return ResponseEntity(HttpStatus.CREATED)
    }

}
