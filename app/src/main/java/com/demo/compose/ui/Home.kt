package com.demo.compose.ui

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.layout
import androidx.lifecycle.viewmodel.compose.viewModel
import com.demo.compose.WeViewModel
import com.demo.compose.ui.chat.ChatDetail
import com.demo.compose.ui.chat.ChatList
import com.demo.compose.ui.contact.ContactPage
import com.demo.compose.ui.discovery.DiscoveryPage
import com.demo.compose.ui.me.MePage
import kotlin.math.roundToInt

@Composable
fun Home() {
    val viewModel: WeViewModel = viewModel()
    Box {
        Column(Modifier.fillMaxSize()) {
            val pagerState: PagerState = remember(viewModel.theme) {
                PagerState(maxPage = 3)
            }

            Pager(pagerState, Modifier.weight(1f)) {
                when (page) {
                    0 -> ChatList(viewModel.chatList)
                    1 -> ContactPage()
                    2 -> DiscoveryPage()
                    3 -> MePage()
                }
            }
            HomeBottomBar(pagerState.currentPage) {
                pagerState.currentPage = it
            }
        }

        // 以下是聊天详情页面
        val offsetPercent = animateFloatAsState(if (viewModel.chatting) 0f else 1f)

        if (viewModel.currentChat != null) {
            ChatDetail(
                Modifier.offsetPercentX(offsetPercent.value),
                chat = viewModel.currentChat
            ) {
                viewModel.endChat()
            }
        }
    }
}

fun Modifier.offsetPercentX(percent: Float): Modifier = layout { measurable, constraints ->
    val placeable = measurable.measure(constraints)
    layout(placeable.width, placeable.height) {
        placeable.placeRelative((percent * placeable.width).roundToInt(), 0)
    }
}