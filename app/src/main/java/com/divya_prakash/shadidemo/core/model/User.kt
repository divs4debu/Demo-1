package com.divya_prakash.shadidemo.core.model

data class User(val userId: String,
                val name: String,
                val email: String,
                val gender: Gender,
                var state: State
                )

enum class Gender {
    Male,
    Female
}

enum class State{
    Accepted,
    Rejected,
    Default
}