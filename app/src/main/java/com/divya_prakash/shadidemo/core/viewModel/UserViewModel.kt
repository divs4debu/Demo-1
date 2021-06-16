package com.divya_prakash.shadidemo.core.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.divya_prakash.shadidemo.core.model.IUserRepository
import com.divya_prakash.shadidemo.core.model.State
import com.divya_prakash.shadidemo.core.model.User

class UserViewModel(private val userRepository: IUserRepository) : ViewModel() {
    private val userLiveData = MutableLiveData<List<User>>()
    fun accept(user: User) {
        user.state = State.Accepted
        userRepository.accept(user)
    }

    fun reject(user: User) {
        user.state = State.Rejected
        userRepository.reject(user)
    }

    fun getUsers(): LiveData<List<User>> = userLiveData
}