package com.store.config

import com.store.constants.ProductType
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test

class StringToProductTypeConverterTest{

    @Test
    fun stringToProductConvertTest() {
        val converter = StringToProductTypeConverter()
        assertEquals(ProductType.GADGET, converter.convert("gadget"))
        assertEquals(ProductType.OTHER, converter.convert("other"))
        assertThrows(IllegalArgumentException::class.java) { converter.convert("invalid") }
    }

}