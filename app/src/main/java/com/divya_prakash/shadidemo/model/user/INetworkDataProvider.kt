package com.divya_prakash.shadidemo.model.user

import com.divya_prakash.shadidemo.core.model.User
import kotlinx.coroutines.flow.Flow

interface INetworkDataProvider {
    suspend fun getUser(): List<User>
}