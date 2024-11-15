package com.store.dto

import com.store.constants.ProductType
import jakarta.validation.constraints.Max
import jakarta.validation.constraints.Min
import java.math.BigDecimal

data class ProductCreateRequest(
    val name: String,
    val type: ProductType,
    @field:Min(1) @field:Max(9999)
    val inventory: Int,
    val cost: BigDecimal = BigDecimal.ZERO
)