package com.example.jetsnack.services

import android.app.Service
import android.content.Intent
import android.os.IBinder
import com.example.jetsnack.model.Snack
import com.example.jetsnack.model.SnackRepo
import com.example.jetsnack.model.snacks
import com.udea.spaceexplorer.infrastructure.retrofitService.RetrofitServiceFactory
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class InventorySyncService : Service() {
    override fun onBind(intent: Intent): IBinder? {
        return null
    }
    
    @OptIn(DelicateCoroutinesApi::class)
    override fun onStartCommand(intent: Intent, flags: Int, startId: Int): Int {
        GlobalScope.launch {
            snacks = getSnacks()
        }
        return START_NOT_STICKY
    }
    
    suspend fun getSnacks() : List<Snack> {
        return RetrofitServiceFactory.makeRetrofitService().getSnacks()
    }
    
    override fun onDestroy() {
        super.onDestroy()
        
    }
}





