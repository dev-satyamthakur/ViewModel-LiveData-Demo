package com.satyamthakur.livedataviewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
    lateinit var viewModel: MainViewModel
    lateinit var displayTv: TextView
    lateinit var boolTv: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        incrementText()

        // getting the textViews
        displayTv = findViewById(R.id.display_tv)
        boolTv = findViewById(R.id.boolean_tv)

        viewModel.currentNumber.observe(this, Observer {
            displayTv.text = it.toString()
        })

        viewModel.currentBool.observe(this, Observer {
            if (it)
                boolTv.text = "Even"
            else
                boolTv.text = "Odd"
        })
    }

    private fun incrementText() {
        val btn = findViewById<Button>(R.id.increment_btn)
        btn.setOnClickListener {
            viewModel.currentNumber.value = ++viewModel.number
            viewModel.currentBool.value = viewModel.number % 2 == 0
        }
    }
}