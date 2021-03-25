package com.demo.compose

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.demo.compose.data.Chat
import com.demo.compose.data.Msg
import com.demo.compose.data.User
import com.demo.compose.ui.theme.WeTheme
import com.demo.compose.util.simpleFormat

class WeViewModel : ViewModel() {
    var theme by mutableStateOf(WeTheme.Theme.Light)
    var chatList by mutableStateOf(
        listOf(
            Chat(
                friend = User.Gao,
                mutableStateListOf(
                    Msg(User.Gao, "锄禾日当午", "10:20"),
                    Msg(User.Me, "汗滴禾下土", "10:22"),
                    Msg(User.Gao, "谁知盘中餐", "10:30"),
                    Msg(User.Me, "粒粒皆辛苦", "11:04"),
                    Msg(User.Gao, "唧唧复唧唧，木兰当户织。不闻机杼声，惟闻女叹息。", "11:21"),
                    Msg(User.Me, "双兔傍地走，安能辨我是雄雌？", "11:40"),
                    Msg(User.Gao, "床前明月光，疑是地上霜。", "11:41"),
                    Msg(User.Me, "吃饭吧？", "12:00"),
                )
            ),
            Chat(
                friend = User.Diu,
                mutableStateListOf(
                    Msg(User.Diu, "哈哈哈", "8:20"),
                    Msg(User.Me, "你笑个屁呀", "8:24"),
                )
            ),
        )
    )
    var currentChat: Chat? by mutableStateOf(null)
    var chatting by mutableStateOf(false)

    fun startChat(chat: Chat) {
        chatting = true
        currentChat = chat
    }

    fun endChat() {
        chatting = false
    }

    fun boom(chat: Chat) {
        chat.msgList.add(
            Msg(User.Me, "\uD83D\uDCA3", System.currentTimeMillis().simpleFormat())
                .apply { read = true }
        )
    }

    fun read(chat: Chat) {
        for (msg in chat.msgList) {
            msg.read = true
        }
    }
}