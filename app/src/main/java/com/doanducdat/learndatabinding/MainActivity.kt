package com.doanducdat.learndatabinding

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.doanducdat.learndatabinding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

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

