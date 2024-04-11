package com.technopradyumn.listproducts.domain

import com.technopradyumn.listproducts.data.Product
import com.technopradyumn.listproducts.data.ProductService

class ProductRepository(private val productService: ProductService) {

    suspend fun getProducts(): List<Product> {
        return productService.getProducts().products
    }
}

