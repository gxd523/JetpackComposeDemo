package com.demo.compose.data

data class Chat(var friend: User, var msgs: MutableList<Msg>)