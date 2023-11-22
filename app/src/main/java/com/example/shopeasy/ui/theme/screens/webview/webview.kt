package com.example.shopeasy.ui.theme.screens.webview

import android.annotation.SuppressLint
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidView
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@SuppressLint("SuspiciousIndentation")
@Composable
fun webviewscreen(navController: NavHostController) {
  val  url = "https://www.google.com/"
    AndroidView(factory = {
        WebView(it).apply {
            webViewClient = WebViewClient()
            loadUrl(url)
        }
    })
}

@Preview
@Composable
fun webviewscreenprev() {
    webviewscreen(rememberNavController())

}