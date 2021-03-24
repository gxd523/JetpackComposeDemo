package com.demo.compose.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.demo.compose.WeViewModel
import com.demo.compose.data.Chat
import com.demo.compose.ui.theme.WeTheme
import com.demo.compose.util.yes

@Composable
fun ChatList(chatList: List<Chat>) {
    Column(
        Modifier
            .background(WeTheme.colors.background)
            .fillMaxSize()
    ) {
        WeTopBar("微信")
        LazyColumn(Modifier.background(WeTheme.colors.listItem)) {
            itemsIndexed(chatList) { index, chat ->
                ChatListItem(chat)
                (index < chatList.size - 1).yes {
                    Divider(
                        startIndent = 68.dp,
                        color = WeTheme.colors.chatListDivider,
                        thickness = 0.8f.dp
                    )
                }
            }
        }
    }
}

@Composable
private fun ChatListItem(chat: Chat) {
    val viewModel: WeViewModel = viewModel()
    Row(
        Modifier
            .fillMaxWidth()
            .clickable { viewModel.startChat(chat) }
    ) {
        Image(
            painter = painterResource(chat.friend.avatar),
            contentDescription = chat.friend.name,
            modifier = Modifier
                .padding(8.dp)
                .size(48.dp)
                .unread(!chat.msgs.last().read, WeTheme.colors.badge)
                .clip(RoundedCornerShape(4.dp))
        )
        Column(
            Modifier
                .weight(1f)
                .align(Alignment.CenterVertically)
        ) {
            Text(
                text = chat.friend.name,
                fontSize = 17.sp,
                color = WeTheme.colors.textPrimary
            )
            Text(
                text = chat.msgs.last().text,
                fontSize = 14.sp,
                color = WeTheme.colors.textSecondary
            )
        }
        Text(
            chat.msgs.last().time,
            Modifier.padding(8.dp, 8.dp, 12.dp, 8.dp),
            fontSize = 11.sp,
            color = WeTheme.colors.textSecondary
        )
    }
}

fun Modifier.unread(show: Boolean, badgeColor: Color = Color.Red): Modifier =
    drawWithContent {
        drawContent()
        show.yes {
            drawIntoCanvas { canvas ->
                val paint = Paint().apply { this.color = badgeColor }
                canvas.drawCircle(
                    Offset(size.width - 1.dp.toPx(), 1.dp.toPx()),
                    5.dp.toPx(),
                    paint
                )
            }
        }
    }