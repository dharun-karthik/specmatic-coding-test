package com.store.controllers

import com.store.constants.ProductType
import com.store.dto.ProductCreateRequest
import com.store.dto.ProductCreateResponse
import com.store.entity.Product
import com.store.service.ProductService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/products")
class ProductController(private val productService: ProductService) {

    @GetMapping
    fun getProducts(@RequestParam(required = false) type: ProductType?): ResponseEntity<List<Product>> {
        val products = productService.getProducts(type)
        return ResponseEntity(products, HttpStatus.OK)
    }

    @PostMapping
    fun addProducts(@Valid @RequestBody newProductRequest: ProductCreateRequest): ResponseEntity<Any> {
        return ResponseEntity(ProductCreateResponse(productService.addProduct(newProductRequest)), HttpStatus.CREATED)
    }

}
