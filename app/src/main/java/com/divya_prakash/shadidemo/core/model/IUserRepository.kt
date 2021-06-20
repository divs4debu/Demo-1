package com.divya_prakash.shadidemo.core.model

import kotlinx.coroutines.flow.Flow


interface IUserRepository {
    suspend fun getUsers(): Flow<List<User>>
    suspend fun accept(user: User): Flow<Boolean>
    suspend fun reject(user: User): Flow<Boolean>
}