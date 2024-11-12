package com.store.entity

import com.store.constants.ProductType

data class Product(
    val id: Int,
    val name: String,
    val type: ProductType,
    val inventory: Int
)