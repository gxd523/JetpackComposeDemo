package com.demo.compose.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.viewmodel.compose.viewModel
import com.demo.compose.WeViewModel

@Composable
fun Home() {
    val viewModel: WeViewModel = viewModel()
    Column {
        val pagerState: PagerState = remember(viewModel.theme) {
            PagerState(maxPage = 3)
        }
        Pager(pagerState, Modifier.weight(1f)) {
            when (page) {
                0 -> ChatList(viewModel.chatList)
                1 -> Box(
                    Modifier
                        .background(Color.Cyan)
                        .fillMaxSize()
                )
                2 -> Box(
                    Modifier
                        .background(Color.Green)
                        .fillMaxSize()
                )
                3 -> Box(
                    Modifier
                        .background(Color.Yellow)
                        .fillMaxSize()
                )
            }
        }
        WeBottomBar(viewModel.selectedTab)
    }
}