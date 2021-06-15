package com.divya_prakash.shadidemo.core.model

data class User(val userId: String,
                val name: String,
                val email: String,
                val gender: Gender
                )

enum class Gender {
    Male,
    Female
}