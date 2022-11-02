package com.example.parcialtp3grupo4.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.parcialtp3grupo4.R
import com.example.parcialtp3grupo4.entities.Product
import java.io.Serializable

class ProductHolder(v: View) : RecyclerView.ViewHolder(v), Serializable {

    private var view: View
    private lateinit var photo: ImageView

    init {
        this.view = v
    }

    fun setName(name: String) {
        val txt: TextView = view.findViewById(R.id.txt_marca_product)
        txt.text = name
    }

    fun setApellido(cat: String) {
        val txt: TextView = view.findViewById(R.id.txt_modelo_product)
        txt.text = cat
    }

    fun setImg(p: Product) {
        photo = view.findViewById(R.id.id_img_product)
        val img: ImageView = view.findViewById(R.id.id_img_product)
        Glide.with(photo.context).load(p.urlImage).into(photo)
    }

    fun getCardLayout(): CardView {
        return view.findViewById(R.id.card_package_item)
    }

}