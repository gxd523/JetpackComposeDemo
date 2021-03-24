package com.demo.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.lifecycle.viewmodel.compose.viewModel
import com.demo.compose.ui.WeBottomBar
import com.demo.compose.ui.theme.WeTheme

class WeChatActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            WeTheme {
                Column {
                    val viewModel: WeViewModel = viewModel()
                    WeBottomBar(viewModel.selectedTab)
                }
            }
        }
    }
}