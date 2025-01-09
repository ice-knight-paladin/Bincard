package com.example.bincard

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler
import com.example.bincard.databinding.ActivityBaseDataBinding

class BaseData : AppCompatActivity() {
    private lateinit var binding: ActivityBaseDataBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBaseDataBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = Adapter()
        binding.list.adapter = adapter

    }

    override fun onBackPressed() {
        super.onBackPressed()
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}