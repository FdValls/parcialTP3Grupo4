package com.example.parcialtp3grupo4.entities

import java.io.Serializable

class Product(marca: String, modelo: String, urlImage: String): Serializable{

    var marca: String = ""

    var modelo: String = ""

    var urlImage: String = ""

    init {
        this.marca = marca!!
        this.modelo = modelo!!
        this.urlImage = urlImage!!
    }


}