package com.demo.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.demo.compose.ui.Home
import com.demo.compose.ui.theme.WeTheme

class MainActivity : ComponentActivity() {
    private val viewModel: WeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            WeTheme(viewModel.theme) { Home() }
        }
    }

    override fun onBackPressed() {
        if (viewModel.chatting) {
            viewModel.endChat()
        } else {
            super.onBackPressed()
        }
    }
}