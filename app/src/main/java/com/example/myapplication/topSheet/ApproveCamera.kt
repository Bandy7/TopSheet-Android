package com.example.myapplication.topSheet

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.R
import com.example.myapplication.components.MyIcon
import com.example.myapplication.components.MyText

@Composable
fun ApproveCamera() {
    Column (
        modifier = Modifier
            .padding(top = 43.dp, bottom = 24.dp)
            .fillMaxWidth()
    ){
        MyText(
            text = "Approve Camera?",
            fontSize = 16.sp,
            modifier = Modifier.padding(start = 24.dp)
        )
        Spacer(modifier = Modifier.padding(top = 20.dp))
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 18.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround
        ){
            ApproveBox(
                color = Color(0xFFEEFBEE),
                painter = painterResource(id = R.drawable.like)
            )
            ApproveBox(
                color = Color(0xFFFDEDEB),
                painter = painterResource(id = R.drawable.dislike)
            )
            ApproveBox(
                color = Color(0xFFEBF8FF),
                painter = painterResource(id = R.drawable.message)
            )
        }
    }
}

@Composable
fun ApproveBox(
    width: Dp = 107.dp,
    height: Dp = 52.dp,
    color: Color,
    shape: RoundedCornerShape = RoundedCornerShape(15.dp),
    painter: Painter
) {
    Box (
        modifier = Modifier
            .width(width)
            .height(height)
            .background(
                color,
                shape = shape
            ),
        contentAlignment = Alignment.Center
    ){
        MyIcon(painter = painter)
    }
}