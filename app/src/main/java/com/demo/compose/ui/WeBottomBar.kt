package com.demo.compose.ui

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.demo.compose.R
import com.demo.compose.WeViewModel
import com.demo.compose.ui.theme.WeTheme

@Composable
fun WeBottomBar(selected: Int) {
    Row(Modifier.background(WeTheme.colors.bottomBar)) {
        val viewModel: WeViewModel = viewModel()
        TabItem(
            if (selected == 0) R.drawable.ic_chat_filled else R.drawable.ic_chat_outlined,
            "聊天",
            if (selected == 0) WeTheme.colors.iconCurrent else WeTheme.colors.icon,
            Modifier
                .clickable { viewModel.selectedTab = 0 }
                .weight(1f)
        )
        TabItem(
            if (selected == 1) R.drawable.ic_contacts_filled else R.drawable.ic_contacts_outlined,
            "通讯录",
            if (selected == 1) WeTheme.colors.iconCurrent else WeTheme.colors.icon,
            Modifier
                .clickable { viewModel.selectedTab = 1 }
                .weight(1f)
        )
        TabItem(
            if (selected == 2) R.drawable.ic_discover_filled else R.drawable.ic_discover_outlined,
            "发现",
            if (selected == 2) WeTheme.colors.iconCurrent else WeTheme.colors.icon,
            Modifier
                .clickable { viewModel.selectedTab = 2 }
                .weight(1f)
        )
        TabItem(
            if (selected == 3) R.drawable.ic_me_filled else R.drawable.ic_me_outlined,
            "我",
            if (selected == 3) WeTheme.colors.iconCurrent else WeTheme.colors.icon,
            Modifier
                .clickable { viewModel.selectedTab = 3 }
                .weight(1f)
        )
    }
}

@Composable
private fun TabItem(
    @DrawableRes iconId: Int,
    title: String,
    tint: Color,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.padding(vertical = 8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,

        ) {
        Icon(
            painter = painterResource(iconId),
            contentDescription = title,
            tint = tint,
            modifier = Modifier.size(24.dp)
        )
        Text(title, fontSize = 11.sp, color = tint)
    }
}

@Preview(showBackground = true)
@Composable
fun WeBottomBarPreview() {
    WeTheme(WeTheme.Theme.Light) {
        WeBottomBar(1)
    }
}

@Preview(showBackground = true)
@Composable
fun WeBottomBarDarkPreview() {
    WeTheme(WeTheme.Theme.Dark) {
        WeBottomBar(1)
    }
}

@Preview(showBackground = true)
@Composable
fun WeBottomBarNewYearPreview() {
    WeTheme(WeTheme.Theme.NewYear) {
        WeBottomBar(1)
    }
}