package com.divya_prakash.shadidemo.core

import android.view.View
import com.divya_prakash.shadidemo.core.model.Gender
import com.divya_prakash.shadidemo.core.model.State
import com.divya_prakash.shadidemo.core.model.User
import com.divya_prakash.shadidemo.core.model.IUserRepository
import com.divya_prakash.shadidemo.core.viewModel.UserViewModel
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner


@RunWith(MockitoJUnitRunner::class)
class UserViewModelTests {

    @Mock lateinit var userRepository: IUserRepository
    @Mock lateinit var view: View

    @InjectMocks
    private lateinit var userViewModel: UserViewModel

    private lateinit var users: List<User>

    @Before
    fun setup() {
        users = mutableListOf<User>(User("abyss", "Abbys", "abyss@gmail.com", Gender.Female, State.Default),
            User("abyss", "Abbys", "abyss@gmail.com", Gender.Female, State.Default),
            User("jenna", "Jenna", "jenna@gmail.com", Gender.Female, State.Default),
            User("cole", "Cole", "cole@gmail.com", Gender.Male, State.Default),
            User("mathew", "Mathew", "mathew@gmail.com", Gender.Male, State.Default),
            User("ross", "Ross", "ross@gmail.com", Gender.Male, State.Default),
            User("pheboe", "Pheboe", "pheboe@gmail.com", Gender.Female, State.Default),
            User("rachel", "Rachel", "rachel@gmail.com", Gender.Female, State.Default),
            User("joey", "Joey", "joey@gmail.com", Gender.Male, State.Default),
            User("monica", "Monica", "monica@gmail.com", Gender.Female, State.Default)
        )
    }

    @Test
    fun `are users received from user provider`() {
        Mockito.`when`(userRepository.getUsers()).thenReturn(users)
        Assert.assertEquals("User from provider", users, userRepository.getUsers())
    }

    @Test
    fun `does accept user call on viewmodel calls repository method`() {
        userViewModel.accept(users[0])
        Mockito.verify(userRepository).accept(users[0])
    }

    @Test
    fun `does reject on viewmodel calls reject method of repository`() {
        userViewModel.reject(users[0])
        Mockito.verify(userRepository).reject(users[0])
    }

    @Test
    fun `is user state change to accepted when user is accepted`() {
        userViewModel.accept(users[0])
        Assert.assertEquals("User state must be accepted", State.Accepted, users[0].state)
    }

    @Test
    fun `is user state change to reject when user is rejected`() {
        userViewModel.reject(users[0])
        Assert.assertEquals("User must be rejected", State.Rejected, users[0].state)
    }

}