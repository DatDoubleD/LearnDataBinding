package com.doanducdat.learndatabinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.doanducdat.learndatabinding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    val MainBinding: ActivityMainBinding by lazy {
        DataBindingUtil.setContentView(this, R.layout.activity_main)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MainBinding.rcvMain.setHasFixedSize(true)
        val adapter = UserAdapter()
        MainBinding.rcvMain.adapter = adapter
        adapter.userList = fakeDataUser()
    }

    private fun fakeDataUser(): MutableList<User> {
        val userList: MutableList<User> = mutableListOf()
        for (i in 0..20){
            userList.add(User("User số $i", i))
        }
        userList.shuffle() // trộn
        return userList
    }
}