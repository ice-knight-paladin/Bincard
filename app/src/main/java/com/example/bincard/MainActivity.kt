package com.example.bincard

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.bincard.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: BankCardViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.lookupButton.setOnClickListener {
            if (binding.binInput.text.toString().trim().isNotEmpty()) {
                viewModel.fetchBankCardInfo(binding.binInput.text.toString().trim())

            }
        }
        var itemUi: ItemUi
        val repository = Repository.Base(Core(this).dao(), Now.Base())
        viewModel.cardInfo.observe(this) { info ->
            run {
                itemUi = ItemUi(
                    "Страна: ${info.country.name}\n" + "Тип карты: ${info.brand} (${info.type})\n" + "Банк: ${info.bank.name}\n" + "Сайт: ${info.bank.url}\n" + "Телефон: ${info.bank.phone}\n" + "Город: ${info.bank.city}\n" + "Координаты: ${info.country.latitude}, ${info.country.longitude}"
                )
                binding.resultText.text = itemUi.getText()
                Log.v(
                    "ffff",
                    "Карта: ${binding.binInput.text.toString().trim()}\n" + itemUi.getText()
                )
                CoroutineScope(SupervisorJob() + Dispatchers.Main.immediate).launch(Dispatchers.IO) {
                    repository.add(
                        "Карта: ${binding.binInput.text.toString().trim()}\n" + itemUi.getText()
                    )
                }
            }
        }
        binding.btnNext.setOnClickListener {
            val intent = Intent(this, BaseData::class.java)
            startActivity(intent)
            finish()
        }
    }
}