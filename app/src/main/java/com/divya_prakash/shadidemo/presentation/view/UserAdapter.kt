package com.divya_prakash.shadidemo.presentation.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.findViewTreeLifecycleOwner
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.divya_prakash.shadidemo.R
import com.divya_prakash.shadidemo.core.model.State
import com.divya_prakash.shadidemo.core.model.User
import com.divya_prakash.shadidemo.core.viewModel.UserViewModel
import com.divya_prakash.shadidemo.databinding.UserLayoutBinding

class UserAdapter(private val userViewModel: UserViewModel) : ListAdapter<User, UserAdapter.ViewHolder>(UserDiffCallback) {

    private lateinit var  parent: ViewGroup
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        this.parent = parent
        val binding: UserLayoutBinding =  DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.user_layout, parent, false)
        return ViewHolder(userViewModel, binding,parent.findViewTreeLifecycleOwner())
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ViewHolder(private val userViewModel: UserViewModel, val binding: UserLayoutBinding, val lifecycleOwner: LifecycleOwner?) : RecyclerView.ViewHolder(binding.root) {

        fun bind(user: User) {
            binding.user = user
            binding.viewModel = userViewModel
            lifecycleOwner?.let { userViewModel.userUpdateLiveData.observe(it, {
                binding.user = user
            }) }
        }
    }
}

object UserDiffCallback : DiffUtil.ItemCallback<User>() {
    override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
        return oldItem.userId == newItem.userId
    }

}