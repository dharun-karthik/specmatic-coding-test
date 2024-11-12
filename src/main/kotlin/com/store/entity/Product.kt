package com.store.entity

import com.fasterxml.jackson.annotation.JsonInclude

@JsonInclude(JsonInclude.Include.NON_NULL)
data class Product(
    val id: Int,
    val name: String?,
    val type: String?,
    val inventory: Int?
)