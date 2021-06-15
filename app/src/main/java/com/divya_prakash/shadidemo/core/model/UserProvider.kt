package com.divya_prakash.shadidemo.core.model

interface UserProvider {
    fun getUsers(): List<User>
}