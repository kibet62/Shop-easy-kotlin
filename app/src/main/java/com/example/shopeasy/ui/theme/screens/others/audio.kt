package com.example.shopeasy.ui.theme.screens.others

import android.net.Uri
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@Composable
fun audio(navController: NavHostController) {
    val uri1 = "https://www.jumia.co.ke/home-audio-electronics/"
    val uri2 = "https://jiji.co.ke/search?query=audio"
    val uri3 = "https://www.alibaba.com/trade/search?spm=a2700.galleryofferlist.pageModule_fy23_pc_search_bar.keydown__Enter&tab=all&searchText=audio"
    val uri4 = "https://www.aliexpress.com/w/wholesale-audio.html?spm=a2g0o.productlist.auto_suggest.1.35e37d97dHdfuJ"
    val uri5 = "https://www.kilimall.co.ke/new/commoditysearch?q=audio"
    Column(
        modifier = Modifier
            .padding(16.dp)
            .clickable { },

        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Row {

            BoxWithName(name = "JUMIA", color = Color.Yellow,parse = Uri.parse(uri1))
            BoxWithName(name = "GLOVO", color = Color.White, parse = Uri.parse(""))
        }
        Row {
            BoxWithName(name = "JIJI", color = Color.Green, parse = Uri.parse(uri2))
            BoxWithName(name = "ALIBABA", color = Color.Magenta, parse = Uri.parse(uri3))

        }
        Row {
            BoxWithName(name = "ALIEXPRESS", color = Color.Red, parse = Uri.parse(uri4),)
            BoxWithName(name = "KILIMALL", color = Color.Blue, parse = Uri.parse(uri5))
        }

    }
}

@Composable
fun BoxWithName(name: String, color: Color, parse: Uri) {
    Surface(
        modifier = Modifier
            .padding(8.dp)
            .shadow(elevation = 4.dp, shape = RoundedCornerShape(8.dp))
            .clickable {},


        color = color,
        shape = RoundedCornerShape(8.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = name, fontSize = 15.sp)
        }

    }

}

@Preview
@Composable
fun audioprev() {
    audio(rememberNavController())
}
