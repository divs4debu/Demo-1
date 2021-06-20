package com.divya_prakash.shadidemo.model.database

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.divya_prakash.shadidemo.core.model.Gender
import com.divya_prakash.shadidemo.core.model.State
import com.divya_prakash.shadidemo.core.model.User
import com.divya_prakash.shadidemo.model.user.IDatabaseDataProvider
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class DatabaseDataProvider: IDatabaseDataProvider {
    private val userLiveData = MutableLiveData<List<User>>()
    private var users = mutableListOf<User>(
        User("abyss", "Abbys", "abyss@gmail.com", Gender.Female, State.Default),
        User("mark", "Mark", "startwars@gmail.com", Gender.Male, State.Default),
        User("jenna", "Jenna", "jenna@gmail.com", Gender.Female, State.Default),
        User("cole", "Cole", "cole@gmail.com", Gender.Male, State.Default),
        User("mathew", "Mathew", "mathew@gmail.com", Gender.Male, State.Default),
        User("ross", "Ross", "ross@gmail.com", Gender.Male, State.Default),
        User("pheboe", "Pheboe", "pheboe@gmail.com", Gender.Female, State.Default),
        User("rachel", "Rachel", "rachel@gmail.com", Gender.Female, State.Default),
        User("joey", "Joey", "joey@gmail.com", Gender.Male, State.Default),
        User("monica", "Monica", "monica@gmail.com", Gender.Female, State.Default)
    )
    override suspend fun getUser(): List<User> {
        return users
    }

    override suspend fun accept(user: User): Boolean {
        for(databaseUser in users) {
           if( user.userId == databaseUser.userId) databaseUser.state = State.Accepted
        }
        return true
    }

    override suspend fun reject(user: User): Boolean {
        for(databaseUser in users) {
            if( user.userId == databaseUser.userId) databaseUser.state = State.Rejected
        }
        return true
    }

    override suspend fun updateData(users: List<User>) {
        val userIds = this.users.map { user -> user.userId }
        for(user in users) {
            if(!userIds.contains(user.userId))
                this.users.add(user)
        }
    }

}