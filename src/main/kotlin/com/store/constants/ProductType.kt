package com.store.constants

import com.fasterxml.jackson.annotation.JsonValue

enum class ProductType {
    BOOK,
    FOOD,
    GADGET,
    OTHER;

    @JsonValue
    override fun toString(): String {
        return name.lowercase();
    }
}