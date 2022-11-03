package com.example.parcialtp3grupo4.recycleview

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.parcialtp3grupo4.R
import com.example.parcialtp3grupo4.adapter.ProductAdapter
import com.example.parcialtp3grupo4.entities.Product
import com.google.android.material.snackbar.Snackbar
import java.io.Serializable

class ListProductFragment : Fragment(), Serializable {

    lateinit var v: View
    lateinit var recProduct: RecyclerView
    var products: MutableList<Product> = ArrayList()
    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var productListAdapter: ProductAdapter
    lateinit var nombre: String
    lateinit var passwd: String
    private lateinit var title: TextView

    companion object {
        fun newInstance() = ListProductFragment()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        v = inflater.inflate(R.layout.fragment_list_product, container, false)

        recProduct = v.findViewById(R.id.rec_list_product)

        return v
    }

    override fun onStart() {
        super.onStart()


        for (i in 1..5) {
            products.add(
                Product(
                    "Chevrolet",
                    "Corvette",
                    "https://www.autobild.es/sites/autobild.es/public/styles/855/public/dc/fotos/Chevrolet_Corvette_6.jpg?itok=odmvJLKt"
                )
            )
            products.add(
                Product(
                    "Ford",
                    "Mustang GT",
                    "https://www.autobild.es/sites/autobild.es/public/styles/855/public/dc/fotos/Ford_Mustanch_Mach_1_01_0.jpg"
                )
            )
            products.add(
                Product(
                    "Audi",
                    "TT 2.8",
                    "https://cdn-images.motor.es/image/m/1280w/fotos-noticias/2020/11/la-gama-audi-tt-estrena-la-edicion-especial-bronze-selection-202073100-1606299651_2.jpg\n"
                )
            )
        }

        recProduct.setHasFixedSize(true)
        linearLayoutManager = LinearLayoutManager(context)

        recProduct.layoutManager = linearLayoutManager

        productListAdapter = ProductAdapter(products) { x ->
            onItemClick(x)
        }

        recProduct.adapter = productListAdapter

    }

    fun onItemClick(position: Int): Boolean {
        Toast.makeText(activity, "Detalles del productoo", Toast.LENGTH_SHORT)
            .show()
        val myProduct = products[position]
        var a = ListProductFragmentDirections.actionListProductFragmentToProductDetailFragment(myProduct)
        v.findNavController().navigate(a)

        return true
    }
}