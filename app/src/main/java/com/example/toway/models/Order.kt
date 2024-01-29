package com.example.toway.models

data class Order(
    val customerName: String,
    val location: String,
    val problem: String,
    val plateNumber: String,
    val image: String
)
