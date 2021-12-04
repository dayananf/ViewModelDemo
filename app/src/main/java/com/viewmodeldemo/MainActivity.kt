package com.viewmodeldemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.viewmodeldemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainActivityViewModel
    private lateinit var viewModelFactory: MainViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModelFactory = MainViewModelFactory(123)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainActivityViewModel::class.java)
        //   binding.txtCount.text = viewModel.getTotal().toString()

        viewModel.totalData.observe(this, Observer {
            binding.txtCount.text = it.toString()
        })



        binding.btAdd.setOnClickListener {
            viewModel.setTotal(binding.etNumber.text.toString().toInt())
            //  binding.txtCount.text = viewModel.getTotal().toString()
        }
    }
}