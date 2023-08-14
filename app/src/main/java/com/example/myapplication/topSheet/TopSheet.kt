package com.example.myapplication.topSheet

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import com.example.myapplication.R
import com.example.myapplication.components.MyIcon
import com.example.myapplication.components.dpToPx
import com.example.myapplication.components.getStatusBarHeight
import com.example.myapplication.components.mySlideInVertically
import com.example.myapplication.components.mySlideOutVertically
import kotlin.math.roundToInt

@Composable
fun TopSheet() {
    var visible by remember { mutableStateOf(false) }
    val interactionSource = remember { MutableInteractionSource() }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .clickable(
                interactionSource = interactionSource,
                indication = null
            ) {
                visible = false
            },
        contentAlignment = Alignment.Center
    ){
        Button(
            onClick = { visible = !visible }
        ) {
            Text(text = "Click")
        }
        Box (
            modifier = Modifier
                .fillMaxSize()
                .background(color = if (visible) Color.Black.copy(0.3f) else Color.Transparent)
        ){

                AnimatedVisibility(
                    visible = visible,
                    enter = mySlideInVertically(tween(550)),
                    exit = mySlideOutVertically(tween(700))
                ) {
                    var alpha by remember { mutableFloatStateOf(1f) }
                    var offsetY by remember { mutableFloatStateOf(dpToPx(0).toFloat()) }
                    Box(
                        modifier = Modifier
                            .offset { IntOffset(0, offsetY.roundToInt()) }
                            .fillMaxWidth()
                            .pointerInput(Unit) {
                                detectDragGestures(
                                    onDragEnd = {
                                        if (offsetY > -400) {
                                            offsetY = 0f
                                        }
                                        if (offsetY <= -400) {
                                            visible = false
                                        }
                                    },
                                    onDrag = { change, dragAmount ->
                                        offsetY += dragAmount.y
                                        if (offsetY > 0) {
                                            offsetY = 0F
                                        }
                                        alpha += (dragAmount.y / 200)
                                        change.consume()
                                    }
                                )
                            }
                            .clip(
                                shape = RoundedCornerShape(bottomStart = 28.dp, bottomEnd = 28.dp)
                            ),
                    ) {
                        Box(
                            modifier = Modifier
                                .height(384.dp)
                                .background(Color.Transparent),
                            contentAlignment = Alignment.BottomCenter
                        ) {
                            Row(
                                modifier = Modifier
                                    .clickable(
                                        interactionSource = interactionSource,
                                        indication = null
                                    ) {
                                        visible = true
                                    }
                                    .fillMaxWidth(),
                                horizontalArrangement = Arrangement.Center,
                            ) {
                                CircleBox(painter = painterResource(id = R.drawable.volume_slash))
                                CircleBox(painter = painterResource(id = R.drawable.trash))
                                CircleBox(painter = painterResource(id = R.drawable.export))
                            }
                        }
                        Card(
                            modifier = Modifier
                                .clickable(
                                    interactionSource = interactionSource,
                                    indication = null
                                ) {
                                    visible = true
                                }
                                .fillMaxWidth(),
                            colors = CardDefaults.cardColors(containerColor = Color.White),
                            shape = RoundedCornerShape(bottomStart = 28.dp, bottomEnd = 28.dp)
                        ) {
                            val context = LocalContext.current
                            Spacer(modifier = Modifier.padding(top = (getStatusBarHeight(context) + 36).dp))
                            AlertCamera(
                                km = "1.2",
                                name = "Bandy Kamal",
                                alerted = "1802"
                            )
                            ApproveCamera()
                        }
                    }
                }
        }
    }
}

@Composable
fun CircleBox(
    painter: Painter,
    color: Color = Color.White,
    size: Dp = 62.dp
) {
    Box(
        contentAlignment= Alignment.Center,
        modifier = Modifier
            .padding(7.dp)
            .background(color, shape = CircleShape)
            .size(size)
    ){
        MyIcon(painter = painter)
    }
}