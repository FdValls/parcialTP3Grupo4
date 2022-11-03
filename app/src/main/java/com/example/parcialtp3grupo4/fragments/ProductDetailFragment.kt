package com.example.parcialtp3grupo4.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.parcialtp3grupo4.R

class ProductDetailFragment : Fragment() {

    private lateinit var marca: TextView
    private lateinit var modelo: TextView
    private lateinit var productImage: ImageView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_product_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        marca = view.findViewById(R.id.id_marca)
        modelo = view.findViewById(R.id.id_modelo)
        productImage = view.findViewById(R.id.id_img)

        arguments?.let {
            val product = ProductDetailFragmentArgs.fromBundle(it).product

            marca.text = product.marca
            modelo.text = product.modelo
            Glide.with(this)
                .load(product.urlImage)
                .into(productImage)
        }

    }

}