package com.store.service

import com.store.config.ProductList
import com.store.constants.ProductType
import com.store.dto.ProductCreateRequest
import com.store.entity.Product
import junit.framework.TestCase.assertEquals
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
        `when`(productList.getProducts()).thenReturn(emptyList())

        productService.getProducts(null)

        verify(productList, times(1)).getProducts(null)
    }

    @Test
    fun shouldCallTheProductListGetProductsMethodWithProductType() {
        `when`(productList.getProducts(ProductType.GADGET)).thenReturn(emptyList())

        productService.getProducts(ProductType.GADGET)

        verify(productList, times(1)).getProducts(ProductType.GADGET)
    }

    @Test
    fun shouldCallTheProductListAddProductMethod() {
        val productCreateRequest = ProductCreateRequest("abc", ProductType.GADGET, 2)
        `when`(productList.getProducts(null)).thenReturn(
            listOf(
                Product(1, "xyz", ProductType.OTHER, 6),
            )
        )

        productService.addProduct(productCreateRequest)

        verify(productList, times(1)).addProduct(Product(2, "abc", ProductType.GADGET, 2))
    }


    @Test
    fun shouldGenerateProperIdBasedOnTheNumberOfElementsInProductList() {
        `when`(productList.getProducts(null)).thenReturn(listOf())
        val productCreateRequest = ProductCreateRequest("jkl", ProductType.OTHER, 5)

        val id = productService.addProduct(productCreateRequest)

        assertEquals(1, id)
    }
}