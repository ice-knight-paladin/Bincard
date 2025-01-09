package com.example.bincard

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bincard.apii.BankCardRepository
import com.example.bincard.models.BankCardInfo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class BankCardViewModel @Inject constructor(private val repository: BankCardRepository) :
    ViewModel() {

    private val _cardInfo = MutableLiveData<BankCardInfo>()
    val cardInfo: LiveData<BankCardInfo> get() = _cardInfo

    fun fetchBankCardInfo(bin: String) {
        Log.v("ffff", "ffffff")
        viewModelScope.launch(Dispatchers.Main) {
            try {
                val info = repository.getBankCardInfo(bin)
                Log.v("ffff", "ffffff${info}")

                _cardInfo.value = info
            } catch (e: Exception) {
                // Обработка ошибок

            }
        }
    }
}