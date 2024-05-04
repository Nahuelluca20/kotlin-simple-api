package com.example.models

import kotlinx.serialization.Serializable

@Serializable // this means, class Customer can be serializable and de deserialized
data class Customer(val id: String, val firsName: String, val lastName: String, val email: String)

// val: The val keyword in Kotlin is used to declare a read-only variable,
// which means that once it is initialized, the variable's reference to another
// object cannot be changed. However, the contents of the object referenced by the variable
// may change if the object is mutable.
val customerStorage = mutableListOf<Customer>()
