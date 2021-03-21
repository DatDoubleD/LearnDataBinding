package com.doanducdat.learndatabinding

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.doanducdat.learndatabinding.databinding.UserItemBinding

class UserAdapter() :
    RecyclerView.Adapter<UserAdapter.UserViewHolder>() {
    lateinit var onClick: onClick

    inner class UserViewHolder(private val userItemBinding: UserItemBinding) :
        RecyclerView.ViewHolder(userItemBinding.root) {

        fun onBind(user: User, position: Int) {
            userItemBinding.user = user
            userItemBinding.imgClick.setOnClickListener {
                user.like += 1 //update user giong update = funtion trong viewmodel -> k update UI
                userItemBinding.txtNumberLike.text = user.like.toString()
                /*onClick.onItemClick(user, position)*/
            }
        }
    }

    var userList: MutableList<User> = mutableListOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val inflater: LayoutInflater = LayoutInflater.from(parent.context)
        val userItemBinding: UserItemBinding = UserItemBinding.inflate(inflater, parent, false)
        return UserViewHolder(userItemBinding)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.onBind(userList[position], position)
    }

    override fun getItemCount(): Int {
        return userList.size
    }
}