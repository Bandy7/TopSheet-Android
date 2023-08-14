package com.example.myapplication.topSheet

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.R
import com.example.myapplication.components.MyIcon
import com.example.myapplication.components.MyText


@Composable
fun AlertCamera(
    name: String,
    km: String,
    alerted: String
){
    Row (
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ){
        Column(
            modifier = Modifier.padding(start = 24.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start
        ) {
            MyText(
                text = "$km KM away",
                fontSize = 18.sp,
                fontWeight = FontWeight.W400
            )
            Row (
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start
            ){
                MyText(text = "By: $name")
                MyIcon(
                    painter = painterResource(id = R.drawable.shield_tick),
                    modifier = Modifier.padding(start = 6.dp)
                )
            }
            Row (
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start
            ){
                MyIcon(
                    painter = painterResource(id = R.drawable.ic_alerted_car),
                    modifier = Modifier.padding(end = 6.dp)
                )
                MyText(
                    text = "$alerted alerted",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.W500
                    )
            }
        }
        MyIcon(
            painter = painterResource(id = R.drawable.group_6277),
            modifier = Modifier.padding(end = 18.dp),
        )
    }
}

