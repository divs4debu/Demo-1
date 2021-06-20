package com.divya_prakash.shadidemo.model.user

import com.divya_prakash.shadidemo.core.model.User

interface IDatabaseDataProvider {
    suspend fun getUser(): List<User>
    suspend fun accept(user: User): Boolean
    suspend fun reject(user: User): Boolean
    suspend fun updateData(users: List<User>)
}