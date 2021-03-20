package com.doanducdat.learndatabinding

import androidx.databinding.BindingAdapter
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView

@BindingAdapter("app:setAdapter")
fun setAdapter(rcv: RecyclerView, userList: LiveData<MutableList<User>>) {
    val adapter = UserAdapter()
    adapter.userList = userList.value!!
    rcv.adapter = adapter
}