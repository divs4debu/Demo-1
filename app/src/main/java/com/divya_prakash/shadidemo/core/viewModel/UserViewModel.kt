package com.divya_prakash.shadidemo.core.viewModel

import androidx.lifecycle.*
import com.divya_prakash.shadidemo.core.model.IUserRepository
import com.divya_prakash.shadidemo.core.model.State
import com.divya_prakash.shadidemo.core.model.User
import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.collect

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

    fun getUsers(): LiveData<List<User>> {
        viewModelScope.launch {
            userRepository.getUsers().collect{
                userLiveData.postValue(it)
            }
        }
        return userLiveData
    }
}

class UserViewModelFactory(private val userRepository: IUserRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(UserViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return UserViewModel(userRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}