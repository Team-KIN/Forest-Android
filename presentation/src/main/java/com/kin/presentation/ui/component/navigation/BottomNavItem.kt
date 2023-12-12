package com.kin.presentation.ui.component.navigation

import com.teamgrapefruit.presentation.R

sealed class BottomNavItem(
    val title: Int, val icon: Int, val screenRoute: String
) {
    object GroupList: BottomNavItem(R.string.group_text, R.drawable.group_list_icon, GROUPLIST)
    object MyGroup: BottomNavItem(R.string.my_group_text, R.drawable.my_group_icon, MYGROUP)
    object MyPage: BottomNavItem(R.string.my_page_text, R.drawable.my_page_icon, MYPAGE)
}

const val GROUPLIST = "GROUPLIST"
const val MYGROUP = "MYGROUP"
const val MYPAGE = "MYPAGE"