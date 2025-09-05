@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.kaikaiapp.features.novel

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import androidx.compose.ui.res.painterResource
import com.example.kaikaiapp.R


@Composable
fun NovelFeatureScreen(onBack: () -> Unit) {
    var currentPage by remember { mutableStateOf("最近閱讀") }

    // 直接用普通變數表達式
    val topBarTitle = "小說-$currentPage"

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text(topBarTitle) }, // <-- 動態標題
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.Filled.Home, contentDescription = "返回")
                    }
                },
                actions = {
                    IconButton(onClick = { currentPage = "設定" }) {
                        Icon(Icons.Filled.Settings, contentDescription = "設定")
                    }
                }
            )
        },
        bottomBar = {
            NavigationBar {
                NavigationBarItem(
                    selected = currentPage == "最近閱讀",
                    onClick = { currentPage = "最近閱讀" },
                    icon = {
                        Icon(
                            painter = painterResource(id = R.drawable.baseline_schedule_black_48),
                            contentDescription = "最近閱讀"
                        )
                    },
                    label = { Text("最近閱讀") }
                )
                NavigationBarItem(
                    selected = currentPage == "我的小說",
                    onClick = { currentPage = "我的小說" },
                    icon = {
                        Icon(
                            painter = painterResource(id = R.drawable.baseline_library_books_black_48),
                            contentDescription = "我的小說"
                        )
                    },
                    label = { Text("我的小說") }
                )
                NavigationBarItem(
                    selected = currentPage == "下載",
                    onClick = { currentPage = "下載" },
                    icon = {
                        Icon(
                            painter = painterResource(id = R.drawable.baseline_download_black_48),
                            contentDescription = "下載"
                        )
                    },
                    label = { Text("下載") }
                )
                NavigationBarItem(
                    selected = currentPage == "查詢",
                    onClick = { currentPage = "查詢" },
                    icon = {
                        Icon(
                            painter = painterResource(id = R.drawable.baseline_search_black_48),
                            contentDescription = "查詢"
                        )
                    },
                    label = { Text("查詢") }
                )
            }
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {
            when(currentPage) {
                "最近閱讀" -> RecentReadScreen()
                "我的小說" -> MyNovelsScreen()
                "下載" -> DownloadScreen()
                "查詢" -> SearchScreen()
                "設定" -> NovelSettingsScreen()
            }
        }
    }
}
