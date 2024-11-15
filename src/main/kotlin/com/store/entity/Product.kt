package com.store.entity

import com.store.constants.ProductType
import java.math.BigDecimal


data class Product(
    val id: Int,
    val name: String,
    val type: ProductType,
    val inventory: Int,
    val cost: BigDecimal
)