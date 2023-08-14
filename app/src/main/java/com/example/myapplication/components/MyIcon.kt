package com.example.myapplication.components

import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter

@Composable
fun MyIcon(
    modifier: Modifier = Modifier,
    painter: Painter
) {
    Icon(
        modifier = modifier,
        painter = painter,
        contentDescription = null,
        tint = Color.Unspecified,
    )
}