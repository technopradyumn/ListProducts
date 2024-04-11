package com.technopradyumn.listproducts.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.technopradyumn.listproducts.data.Product
import com.technopradyumn.listproducts.domain.ProductRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.HttpException

class ProductViewModel(private val repository: ProductRepository) : ViewModel() {

    private val _products = MutableLiveData<List<Product>>()
    val products: LiveData<List<Product>> get() = _products

    init {
        fetchProducts()
    }

    fun fetchProducts() {

        viewModelScope.launch(Dispatchers.IO) {
            try {
                val products = repository.getProducts()
                _products.postValue(products)
            } catch (e: HttpException) {
            }
        }
    }
}