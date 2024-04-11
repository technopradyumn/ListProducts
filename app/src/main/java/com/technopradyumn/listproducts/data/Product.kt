package com.technopradyumn.listproducts.data

data class Product(
    val id: Int,
    val title: String,
    val description: String,
    val price: Int,
    val discountPercentage: Double,
    val rating: Double,
    val stock: Int,
    val brand: String,
    val category: String,
    val thumbnail: String,
    val images: ArrayList<String>
)

data class Root(
    val products: ArrayList<Product>,
    val total: Int,
    val skip: Int,
    val limit: Int
)

