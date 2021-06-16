package com.divya_prakash.shadidemo.core.model

interface IUserRepository {
    fun getUsers(): List<User>
    fun accept(user: User)
    fun reject(user: User)
}