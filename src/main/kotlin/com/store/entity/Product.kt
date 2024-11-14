package com.store.entity

import com.fasterxml.jackson.annotation.JsonInclude
import com.store.constants.ProductType

@JsonInclude(JsonInclude.Include.NON_NULL)
data class Product(
    val id: Int,
    val name: String,
    val type: ProductType,
    val inventory: Int,
    val cost: Double? = null
)