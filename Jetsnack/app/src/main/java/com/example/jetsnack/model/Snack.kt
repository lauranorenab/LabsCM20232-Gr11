

package com.example.jetsnack.model

import androidx.compose.runtime.Immutable
import java.util.Date

@Immutable
data class Snack(
    val id: Long,
    val name: String,
    val imageUrl: String,
    val price: Long,
    val tagline: String = "",
    val tags: Set<String> = emptySet(),
    val createdAt: Date
)

/**
 * Static data
 */

var snacks = listOf<Snack>()