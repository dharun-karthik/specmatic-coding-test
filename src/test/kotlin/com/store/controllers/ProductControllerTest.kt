package com.store.controllers

import com.store.constants.ProductType
import com.store.dto.ProductCreateRequest
import com.store.entity.Product
import com.store.service.ProductService
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
import org.springframework.util.LinkedMultiValueMap
import org.springframework.util.MultiValueMap

@ExtendWith(MockitoExtension::class)
class ProductControllerTest {

    private lateinit var mockMvc: MockMvc

    private lateinit var productService: ProductService

    @BeforeEach
    fun setUp() {
        productService = mock(ProductService::class.java)
        mockMvc = MockMvcBuilders.standaloneSetup(
            ProductController(productService)
        ).build()
    }

    @Test
    fun getCallShouldReturnProductsWithoutQueryParam() {
        `when`(productService.getProducts(null)).thenReturn(listOf(Product(1, "abc", ProductType.GADGET, 2)))

        mockMvc.perform(get("/products"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$", hasSize<Product>(1)))
            .andExpect(jsonPath("$[0].id").value(1))
            .andExpect(jsonPath("$[0].name").value("abc"))
            .andExpect(jsonPath("$[0].type").value("gadget"))
            .andExpect(jsonPath("$[0].inventory").value(2))
    }

    @Test
    fun getCallShouldReturnProductWithTypeQueryParam() {
        val params: MultiValueMap<String, String> = LinkedMultiValueMap()
        params.add("type", "GADGET")
        `when`(productService.getProducts(ProductType.GADGET)).thenReturn(
            listOf(
                Product(
                    1,
                    "abc",
                    ProductType.GADGET,
                    2
                )
            )
        )

        mockMvc.perform(get("/products").queryParams(params))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$", hasSize<Product>(1)))
            .andExpect(jsonPath("$[0].id").value(1))
            .andExpect(jsonPath("$[0].name").value("abc"))
            .andExpect(jsonPath("$[0].type").value("gadget"))
            .andExpect(jsonPath("$[0].inventory").value(2))
    }

    @Test
    fun getCallShouldReturn400ForIncorrectTypeQueryParam() {
        val params: MultiValueMap<String, String> = LinkedMultiValueMap()
        params.add("type", "GADGETS")

        mockMvc.perform(get("/products").queryParams(params))
            .andExpect(status().isBadRequest)
    }

    @Test
    fun postProductCallShouldReturnId() {

        `when`(productService.addProduct(ProductCreateRequest("abc", ProductType.GADGET, 2))).thenReturn(1)

        mockMvc.perform(
            post("/products")
                .contentType("application/json")
                .content("{\"name\":\"abc\",\"type\":\"gadget\",\"inventory\":2}")
        )
            .andExpect(status().isCreated)
            .andExpect(jsonPath("$.id").value(1))
    }

    @Test
    fun postProductCallShouldReturn400ForIncorrectType() {
        mockMvc.perform(
            post("/products")
                .contentType("application/json")
                .content("{\"name\":abc,\"type\":\"gadget\",\"inventory\":2}")
        )
            .andExpect(status().isBadRequest)
    }
}