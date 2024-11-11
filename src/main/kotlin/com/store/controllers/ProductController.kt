package com.store.controllers

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
    fun getProducts(): ResponseEntity<Any> {
        return ResponseEntity(HttpStatus.OK)
    }

    @PostMapping
    fun addProducts(): ResponseEntity<Any> {
        return ResponseEntity(HttpStatus.CREATED)
    }

}
