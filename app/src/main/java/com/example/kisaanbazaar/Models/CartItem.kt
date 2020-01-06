package com.example.kisaanbazaar.Models

data class CartItem(var name : String,
                    var category : String,
                    var inKg : Boolean,
                    var inDozen : Boolean,
                    var inLitres : Boolean,
                    var price : Float,
                    var oldPrice : Float,
                    var noOfOffersAvailable : Int,
                    var quantity : Int,
                    var deliveryDays : Int,
                    var isFavourite : Boolean)