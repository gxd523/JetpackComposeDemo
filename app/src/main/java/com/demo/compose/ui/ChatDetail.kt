package com.demo.compose.ui

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layout
import androidx.lifecycle.viewmodel.compose.viewModel
import com.demo.compose.WeViewModel
import kotlin.math.roundToInt

@Composable
fun ChatDetail() {
    val viewModel: WeViewModel = viewModel()
    val offsetPercent = animateFloatAsState(if (viewModel.chatting) 0f else 1f)
    Box(
        Modifier
            .offsetPercentX(offsetPercent.value)
            .background(Color.Magenta)
            .fillMaxSize()
    ) {

    }
}

fun Modifier.offsetPercentX(percent: Float): Modifier = layout { measurable, constraints ->
    val placeable = measurable.measure(constraints)
    layout(placeable.width, placeable.height) {
        placeable.placeRelative((percent * placeable.width).roundToInt(), 0)
    }
}