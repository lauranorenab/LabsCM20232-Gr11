package com.udea.spaceexplorer.domain.dto

import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import com.udea.spaceexplorer.infrastructure.retrofitService.RetrofitServiceFactory
import androidx.lifecycle.lifecycleScope

data class SnackDto(
    val id: Long,
    val name: String,
    val imageUrl: String,
    val price: Long,
    val tagline: String = "",
    val tags: Set<String> = emptySet()
)



