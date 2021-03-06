package com.divya_prakash.shadidemo.model.user

import com.divya_prakash.shadidemo.core.model.IUserRepository
import com.divya_prakash.shadidemo.core.model.User
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch

class UserRepository(private val networkDataProvider: INetworkDataProvider, private val databaseDataProvider: IDatabaseDataProvider): IUserRepository {

    private val scope = CoroutineScope(Dispatchers.IO)
    override suspend fun getUsers(): Flow<List<User>> = flow {
        val databaseUsers = databaseDataProvider.getUser()
        emit(databaseUsers)
        delay(5000)
        val networkUsers = networkDataProvider.getUser()
        emit(networkUsers)
    }.flowOn(Dispatchers.IO)

    override suspend fun accept(user: User): Flow<Boolean> = flow {
        val success = databaseDataProvider.accept(user)
        emit(success)
    }

    override suspend fun reject(user: User): Flow<Boolean> = flow {
        val success  = databaseDataProvider.reject(user)
        emit(success)
    }
}