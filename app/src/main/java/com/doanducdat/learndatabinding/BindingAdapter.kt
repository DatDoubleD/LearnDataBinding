package com.doanducdat.learndatabinding

import androidx.databinding.BindingAdapter
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView

@BindingAdapter("app:setAdapter")
fun setAdapter(rcv: RecyclerView, userViewModel: UserViewModel) {
    val adapter = UserAdapter()
    adapter.userList = userViewModel.getUserList().value!!
    adapter.onClick = object : onClick{
        override fun onItemClick(user: User, position: Int) {
            //todo sth
        }
    }
    rcv.adapter = adapter
}