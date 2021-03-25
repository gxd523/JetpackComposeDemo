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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.demo.compose.R
import com.demo.compose.ui.theme.WeTheme

@Composable
fun HomeBottomBar(selected: Int, onTabItemClick: (Int) -> Unit) {
    Row(Modifier.background(WeTheme.colors.bottomBar)) {
        TabItem(
            if (selected == 0) R.drawable.ic_chat_filled else R.drawable.ic_chat_outlined,
            "聊天",
            if (selected == 0) WeTheme.colors.iconCurrent else WeTheme.colors.icon,
            Modifier
                .clickable { onTabItemClick(0) }
                .weight(1f)
        )
        TabItem(
            if (selected == 1) R.drawable.ic_contacts_filled else R.drawable.ic_contacts_outlined,
            "通讯录",
            if (selected == 1) WeTheme.colors.iconCurrent else WeTheme.colors.icon,
            Modifier
                .clickable { onTabItemClick(1) }
                .weight(1f)
        )
        TabItem(
            if (selected == 2) R.drawable.ic_discover_filled else R.drawable.ic_discover_outlined,
            "发现",
            if (selected == 2) WeTheme.colors.iconCurrent else WeTheme.colors.icon,
            Modifier
                .clickable { onTabItemClick(2) }
                .weight(1f)
        )
        TabItem(
            if (selected == 3) R.drawable.ic_me_filled else R.drawable.ic_me_outlined,
            "我",
            if (selected == 3) WeTheme.colors.iconCurrent else WeTheme.colors.icon,
            Modifier
                .clickable { onTabItemClick(3) }
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