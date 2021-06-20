package com.divya_prakash.shadidemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.divya_prakash.shadidemo.core.model.IUserRepository
import com.divya_prakash.shadidemo.core.model.User
import com.divya_prakash.shadidemo.core.viewModel.UserViewModel
import com.divya_prakash.shadidemo.core.viewModel.UserViewModelFactory
import com.divya_prakash.shadidemo.model.database.DatabaseDataProvider
import com.divya_prakash.shadidemo.model.network.NetworkDataProvider
import com.divya_prakash.shadidemo.model.user.IDatabaseDataProvider
import com.divya_prakash.shadidemo.model.user.INetworkDataProvider
import com.divya_prakash.shadidemo.model.user.UserRepository
import com.divya_prakash.shadidemo.presentation.view.UserAdapter

class MainActivity : AppCompatActivity() {

    private val networkDataProvider : INetworkDataProvider = NetworkDataProvider()
    private val databaseDataProvider: IDatabaseDataProvider = DatabaseDataProvider()
    private val userRepository : IUserRepository = UserRepository(networkDataProvider, databaseDataProvider)
    private val userViewModel by viewModels<UserViewModel> {
        UserViewModelFactory(userRepository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val userAdapter = UserAdapter()
        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = userAdapter

        userViewModel.getUsers().observe(this, {
            userAdapter.submitList(it as MutableList<User>)
            Log.d("User", userAdapter.itemCount.toString())
        })

    }
}