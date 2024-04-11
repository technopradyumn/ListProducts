package com.technopradyumn.listproducts.presentation

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.technopradyumn.listproducts.data.RetrofitClient
import com.technopradyumn.listproducts.databinding.ActivityProductsBinding
import com.technopradyumn.listproducts.domain.ProductRepository

class ProductsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProductsBinding
    private lateinit var productAdapter: ProductAdapter
    private val viewModel: ProductViewModel by viewModels {
        ProductViewModelFactory(ProductRepository(RetrofitClient.productService))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityProductsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        productAdapter = ProductAdapter()
        binding.recyclerView.apply {
            adapter = productAdapter
            layoutManager = LinearLayoutManager(this@ProductsActivity)
        }

        viewModel.products.observe(this) { products ->
            productAdapter.setProducts(products)
        }
    }
}