package com.example.jetsnack.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.lifecycleScope
import com.example.jetsnack.model.Snack
import com.example.jetsnack.model.snacks
import com.udea.spaceexplorer.infrastructure.retrofitService.RetrofitServiceFactory
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        val service = RetrofitServiceFactory.makeRetrofitService()
        
        lifecycleScope.launch {
            snacks = service.getSnacks()
            setContent {
                JetsnackApp()
            }
        }
    }
}
