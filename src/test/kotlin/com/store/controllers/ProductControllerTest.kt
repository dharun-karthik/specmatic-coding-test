package com.store.controllers

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

class ProductControllerTest {

    private lateinit var mockMvc: MockMvc

    @BeforeEach
    fun setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(
            ProductController()
        ).build()
    }

    @Test
    fun testGetProducts() {
        mockMvc.perform(get("/products"))
            .andExpect(status().isOk)

    }

    @Test
    fun testPostProduct() {
        mockMvc.perform(post("/products"))
            .andExpect(status().isCreated)
    }
}