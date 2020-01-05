package com.example.kisaanbazaar.Models

data class Product(var name : String,
                   var inKg : Boolean,
                   var inDozen : Boolean,
                   var inLitres : Boolean,
                   var price : Float,
                   var isFavourite : Boolean)