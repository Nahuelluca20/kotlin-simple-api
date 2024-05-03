package com.example.models

import kotlinx.serialization.Serializable

@Serializable // this means, class Customer can be serializable and de deserialized
data class Customer (val id:String, val firsName: String, val lastName: String, val email: String)

val customerStorage = mutableListOf<Customer>()
