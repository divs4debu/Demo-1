package com.divya_prakash.shadidemo.model.network

import com.divya_prakash.shadidemo.core.model.Gender
import com.divya_prakash.shadidemo.core.model.State
import com.divya_prakash.shadidemo.core.model.User
import com.divya_prakash.shadidemo.model.user.INetworkDataProvider
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class NetworkDataProvider: INetworkDataProvider {
    override suspend fun getUser(): List<User> {
        val users =  mutableListOf<User>(User("abyss", "Abbys", "abyss@gmail.com", Gender.Female, State.Default),
            User("chester", "Chester", "linkinpark@gmail.com", Gender.Male, State.Default),
            User("jenna", "Jenna", "jenna@gmail.com", Gender.Female, State.Default),
            User("cole", "Cole", "cole@gmail.com", Gender.Male, State.Default),
            User("mathew", "Mathew", "mathew@gmail.com", Gender.Male, State.Default),
            User("ross", "Ross", "ross@gmail.com", Gender.Male, State.Default),
            User("pheboe", "Pheboe", "pheboe@gmail.com", Gender.Female, State.Default),
            User("rachel", "Rachel", "rachel@gmail.com", Gender.Female, State.Default),
            User("joey", "Joey", "joey@gmail.com", Gender.Male, State.Default),
            User("monica", "Monica", "monica@gmail.com", Gender.Female, State.Default)
        )
        return users
    }
}