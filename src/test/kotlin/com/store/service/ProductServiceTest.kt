package com.store.service

import com.store.config.ProductList
import com.store.constants.ProductType
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.Mockito.*

class ProductServiceTest {
    private lateinit var productService: ProductService
    private lateinit var productList: ProductList

    @BeforeEach
    fun setup() {
        productList = mock(ProductList::class.java)
        productService = ProductService(productList)
    }

    @Test
    fun shouldCallTheProductListGetProductsMethodWithNull() {
        `when`(productList.getProducts(null)).thenReturn(emptyList())
        productService.getProducts(null)
        verify(productList, times(1)).getProducts(null)
    }

    @Test
    fun shouldCallTheProductListGetProductsMethodWithProductType() {
        `when`(productList.getProducts(ProductType.GADGET)).thenReturn(emptyList())
        productService.getProducts(ProductType.GADGET)
        verify(productList, times(1)).getProducts(ProductType.GADGET)
    }
}