package com.store.controllers

import com.store.config.ProductList
import com.store.entity.Product
import org.hamcrest.Matchers.hasSize
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mockito.mock
import org.mockito.Mockito.`when`
import org.mockito.junit.jupiter.MockitoExtension
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import org.springframework.test.web.servlet.setup.MockMvcBuilders

@ExtendWith(MockitoExtension::class)
class ProductControllerTest {

    private lateinit var mockMvc: MockMvc

    private lateinit var productList: ProductList

    @BeforeEach
    fun setUp() {
        productList = mock(ProductList::class.java)
        mockMvc = MockMvcBuilders.standaloneSetup(
            ProductController(productList)
        ).build()
    }

    @Test
    fun testGetProducts() {

        `when`(productList.products).thenReturn(listOf(Product(1, "abc", "gadget", 2)))

        mockMvc.perform(get("/products"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$", hasSize<Product>(1)))
            .andExpect(jsonPath("$[0].id").value(1))
            .andExpect(jsonPath("$[0].name").value("abc"))
            .andExpect(jsonPath("$[0].type").value("gadget"))
            .andExpect(jsonPath("$[0].inventory").value(2))
    }

    @Test
    fun testPostProduct() {
        mockMvc.perform(post("/products"))
            .andExpect(status().isCreated)
    }
}