package com.example.startingserviceslab

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.math.abs

class CountdownService : Service() {

    override fun onBind(intent: Intent): IBinder {
        TODO("Return the communication channel to the service.")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        val time = intent!!.getStringExtra("Time")

        if (time != null) {
            val scope = CoroutineScope(Job() + Dispatchers.Default)
            scope.launch { countdown(time) }
        }
        return super.onStartCommand(intent, flags, startId)
    }

    suspend fun countdown(_num : String){
        val number = _num.toInt()
        repeat(number){
            Log.d("TEST", abs(it-number).toString())
            delay(1000)
        }
    }
}