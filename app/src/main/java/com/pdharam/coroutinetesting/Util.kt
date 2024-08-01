package com.pdharam.coroutinetesting

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class Util(val testDispatcher: CoroutineDispatcher) {

    suspend fun getUserName(): String {
        delay(10000)
        return "PravinDharam"
    }

    suspend fun getUser(): String {

        CoroutineScope(Dispatchers.Main).launch {

            delay(2000)
        }
        return "User - PravinDharam"
    }

    suspend fun getAddress(): String {

        CoroutineScope(testDispatcher).launch {

            delay(5000)
        }
        return "User - PravinDharam"
    }

    var globalArg = false
    fun getAddressDetails() {
        CoroutineScope(testDispatcher).launch {
            globalArg = true
        }
    }
}