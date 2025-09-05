package com.example.kaikaiapp.features.novel

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SearchScreen() {
    // 用來儲存使用者輸入文字
    var queryText by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top
    ) {

        Spacer(modifier = Modifier.height(16.dp))

        // 單行輸入框，按鍵盤「Enter/搜尋」就查詢
        TextField(
            value = queryText,
            onValueChange = { queryText = it },
            label = { Text("請輸入書名") },
            singleLine = true, // 單行
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = ImeAction.Search // 顯示鍵盤搜尋鍵
            ),
            keyboardActions = KeyboardActions(
                onSearch = {
                    // 按鍵盤搜尋鍵時觸發
                    performSearch(queryText)
                }
            )
        )

        Spacer(modifier = Modifier.height(16.dp))

        // 查詢按鈕（可保留，也可以移除）
        Button(
            onClick = { performSearch(queryText) },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("查詢")
        }
    }
}

// 查詢函式（呼叫後端 API 或做其他處理）
private fun performSearch(query: String) {
    println("查詢文字: $query") // 先列印到 Log，之後可改呼叫 API
}
