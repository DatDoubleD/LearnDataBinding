package com.doanducdat.learndatabinding

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.doanducdat.learndatabinding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    //cần override interface lại + truyền cho viewmodel là xong, nhưng đang set trong bindingadapter...chualamdc
    //1. truyen interface override vào: chac k dc
    //2. truyen adapter vào(adapter tạo trong main có xay dung onclick sẵn) app:setAdapter
    val MainBinding: ActivityMainBinding by lazy {
        DataBindingUtil.setContentView(this, R.layout.activity_main)
    }

    val viewModel:UserViewModel by lazy {
        ViewModelProvider(this).get(UserViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        MainBinding.lifecycleOwner = this
        MainBinding.rcvMain.setHasFixedSize(true)
        MainBinding.userModel = viewModel

    }
}

