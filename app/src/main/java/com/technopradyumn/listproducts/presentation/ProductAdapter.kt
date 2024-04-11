package com.technopradyumn.listproducts.presentation


import com.technopradyumn.listproducts.R
import com.technopradyumn.listproducts.data.Product
import com.technopradyumn.listproducts.databinding.ItemProductBinding
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class ProductAdapter : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {
    private var products: List<Product> = emptyList()

    fun setProducts(products: List<Product>) {
        this.products = products
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemProductBinding.inflate(inflater, parent, false)
        return ProductViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.bind(products[position])
    }

    override fun getItemCount(): Int {
        return products.size
    }

    inner class ProductViewHolder(private val binding: ItemProductBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(product: Product) {
            binding.apply {
                Glide.with(itemView.context)
                    .load(product.thumbnail)
                    .placeholder(R.drawable.baseline_production_quantity_limits_24)
                    .error(R.drawable.baseline_production_quantity_limits_24)
                    .into(imageViewThumbnail)

                textViewTitle.text = product.title
                textViewDescription.text = product.description
            }
        }
    }
}