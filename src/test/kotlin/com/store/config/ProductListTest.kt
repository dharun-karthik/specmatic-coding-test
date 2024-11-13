package com.store.config

import com.store.constants.ProductType
import com.store.entity.Product
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class ProductListTest {

    lateinit var productList: ProductList

    @BeforeEach
    fun setup() {
        productList = ProductList(
            listOf(
                Product(1, "abc", ProductType.GADGET, 2),
                Product(2, "def", ProductType.GADGET, 3),
                Product(3, "ghi", ProductType.OTHER, 4)
            )
        )
    }

    @Test
    fun shouldReturnAllProductsWhenTypeIsNull() {
        val products = productList.getProducts(null)

        assertEquals(3, products.size)
    }

    @Test
    fun shouldReturnOnlyProductsOfThatTypeWhenProductTypeIsProvided() {
        val products = productList.getProducts(ProductType.GADGET)

        assertEquals(2, products.size)
        assertEquals(1, products[0].id)
        assertEquals("abc", products[0].name)
        assertEquals(ProductType.GADGET, products[0].type)
        assertEquals(2, products[0].inventory)
        assertEquals(2, products[1].id)
        assertEquals("def", products[1].name)
        assertEquals(ProductType.GADGET, products[1].type)
        assertEquals(3, products[1].inventory)
    }

    @Test
    fun shouldAddProduct() {
        productList.addProduct(Product(4, "jkl", ProductType.OTHER, 5))

        val products = productList.getProducts(null)
        assertEquals(4, products.size)
        assertEquals(4, products[3].id)
        assertEquals("jkl", products[3].name)
        assertEquals(ProductType.OTHER, products[3].type)
        assertEquals(5, products[3].inventory)
    }
}