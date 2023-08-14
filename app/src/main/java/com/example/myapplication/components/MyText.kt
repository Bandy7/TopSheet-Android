package com.example.myapplication.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.example.myapplication.R


@Composable
fun MyText(
    modifier: Modifier = Modifier,
    text: String,
    fontSize: TextUnit = 20.sp,
    fontWeight: FontWeight = FontWeight.W600,
    color: Color = Color(0xFF171729)
) {
    val workSans = FontFamily(
        Font(R.font.work_sans_regular, FontWeight.W400),
        Font(R.font.work_sans_medium, FontWeight.W500),
        Font(R.font.work_sans_semi_bold, FontWeight.W600)
    )
    Text(
        modifier = modifier,
        text = text,
        fontSize = fontSize,
        fontWeight = fontWeight,
        color = color,
        fontFamily = workSans,
    )
}