package com.example.bincard

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.bincard.databinding.ActivityBaseDataBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch

class BaseData : AppCompatActivity() {
    private lateinit var binding: ActivityBaseDataBinding
    private lateinit var list: MutableList<ItemUi>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBaseDataBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val repository = Repository.Base(Core(this).dao(), Now.Base())
        val adapter = Adapter()
        CoroutineScope(SupervisorJob() + Dispatchers.Main.immediate).launch(Dispatchers.IO) {
            list = repository.list().toMutableList()
        }

        binding.list.adapter = adapter


        Handler(Looper.getMainLooper()).postDelayed(
            {
                Log.v("ffff", list.toString())
                for (i in list) {
                    adapter.add(i)
                }
            },
            1000
        )
    }

    override fun onBackPressed() {
        super.onBackPressed()
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}