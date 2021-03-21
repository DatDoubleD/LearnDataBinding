package com.doanducdat.learndatabinding

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class UserViewModel : ViewModel() {
    private var userList: MutableLiveData<MutableList<User>> = MutableLiveData()

    init {
        fakeDataUser()
    }

    private fun fakeDataUser() {
        val user: MutableList<User> = mutableListOf()
        for (i in 0..20) {
            user.add(User("User số $i", i, 0))
        }
        user.shuffle() // trộn
        userList.value = user
    }

    fun getUserList(): LiveData<MutableList<User>> {
        return userList
    }
    //update k auto update UP, phai scroll len + xuong cho item update lai moi co su thay doi
   /* fun updateCountLike(position: Int) {

        userList.value?.get(position)?.like = userList.value?.get(position)?.like?.plus(1) ?: 0
    }*/
}