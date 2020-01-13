package com.example.kisaanbazaar.Models

data class Account( var uid : String,
                    var name : String,
                    var profile_image : String,
                    var account_type : String,
                    var login_type : String,
                    var gender : String,
                    var email : String,
                    var phone : Int,
                    var is_verified : Boolean,
                    var applied_offers : List<String>,
                    var address : Map<String,String>)