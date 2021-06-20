package com.divya_prakash.shadidemo.core.model

import kotlinx.coroutines.flow.Flow


interface IUserRepository {
    fun getUsers(): Flow<List<User>>
    fun accept(user: User)
    fun reject(user: User)
}