package com.latihan.viewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.latihan.viewmodel.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: TestViewModel
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.btnButton
        binding.tvTextview.text ="String"
        viewModel = ViewModelProvider(this).get(TestViewModel::class.java)

         viewModel.currentnumber.observe(this, Observer {
             binding.tvTextview.text = it.toString()                            //pemanggilan variable bindingnya harus lengkap
         })

        viewModel.currentBoolean.observe(this, Observer {
            binding.tvBooleanText.text = it.toString()
        })

        incerementText()
    }

    private fun incerementText() {
        binding.btnButton.setOnClickListener {
            viewModel.currentnumber.value = ++viewModel.number
            viewModel.currentBoolean.value = ++viewModel.number % 3 == 0
        }
    }
}