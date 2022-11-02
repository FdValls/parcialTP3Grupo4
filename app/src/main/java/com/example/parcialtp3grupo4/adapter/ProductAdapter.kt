package com.example.parcialtp3grupo4.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.parcialtp3grupo4.R
import com.example.parcialtp3grupo4.entities.Product

class ProductAdapter(
    private var productList: MutableList<Product>,
    val onItemClick: (Int) -> Boolean
) : RecyclerView.Adapter<ProductHolder>() {

    override fun getItemCount(): Int {
        return productList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_product, parent, false)
        return (ProductHolder(view))
    }

    override fun onBindViewHolder(holder: ProductHolder, position: Int) {

        holder.setName(productList[position].marca)
        holder.setApellido(productList[position].modelo)
        holder.setImg(productList[position])

        holder.getCardLayout().setOnClickListener {
            onItemClick(position)
        }

    }

    fun setData(newData: ArrayList<Product>) {
        this.productList = newData
        this.notifyDataSetChanged()
    }


}