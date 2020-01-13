package com.example.kisaanbazaar.Models

data class Products(var product_id : Int,
                    var name : String,
                    var description : String,
                    var category : String,
                    var sub_category : String,
                    var thumbnail : String,
                    var updated_on : String,
                    var avail_offers : List<String>,
                    var favourites : List<String>,
                    var price : Int,
                    var quantity : Int,
                    var quantity_type : String,
                    var owner_uid : String,
                    var status : Int,
                    var address : Map<String,String>)