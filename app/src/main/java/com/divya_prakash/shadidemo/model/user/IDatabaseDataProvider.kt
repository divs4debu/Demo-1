package com.divya_prakash.shadidemo.model.user

import com.divya_prakash.shadidemo.core.model.User

interface IDatabaseDataProvider {
    suspend fun getUser(): List<User>
    fun accept(user: User)
    fun reject(user: User)
}