package com.demo.compose.data

import androidx.annotation.DrawableRes
import com.demo.compose.R

data class User(val id: String, val name: String, @DrawableRes val avatar: Int) {
    companion object {
        val Me: User = User("rengwuxian", "扔物线-朱凯", R.drawable.avatar_rengwuxian)
        val Gao: User = User("gaolaoshi", "高老师", R.drawable.avatar_gaolaoshi)
        val Diu: User = User("diuwuxian", "丢物线", R.drawable.avatar_diuwuxian)
    }
}