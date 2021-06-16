package com.divya_prakash.shadidemo.core.viewModel

import androidx.lifecycle.ViewModel
import com.divya_prakash.shadidemo.core.model.IUserRepository
import com.divya_prakash.shadidemo.core.model.User

class UserViewModel(val userRepository: IUserRepository) : ViewModel() {
    fun accept(user: User) {
        userRepository.accept(user)
    }

    fun reject(user: User) {
        userRepository.reject(user)
    }
}