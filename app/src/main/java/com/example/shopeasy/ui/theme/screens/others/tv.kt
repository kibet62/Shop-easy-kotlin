package com.example.shopeasy.ui.theme.screens.others

import android.net.Uri
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.shopeasy.R


@Composable
fun tv() {
    val uri1 = "https://www.jumia.co.ke/home-audio-electronics/"
    val uri2 = "https://jiji.co.ke/home-garden?query=automobile"
    val uri3 = "https://www.alibaba.com/trade/search?spm=a2700.product_home_newuser.home_new_user_first_screen_fy23_pc_search_bar.associationItem_pos_0&tab=all&searchText=automobile"
    val uri4 = "https://www.aliexpress.com/w/wholesale-tv.html?catId=0&initiative_id=SB_20231121200815&SearchText=tv&spm=a2g0o.best.1000002.0"
    val uri5 = "https://www.kilimall.co.ke/new/commoditysearch?q=tv"
    val handler = LocalUriHandler.current
    Row(
        Modifier
            .fillMaxWidth()
            .height(30.dp)
    ){
        Icon(painter = painterResource(id = R.drawable.jumia_icon), contentDescription = "Back", modifier = Modifier.clickable { Uri.parse(uri1) })
        Text("TV PRODUCTS", textAlign = TextAlign.Center,
            modifier = Modifier.weight(1f)) // Fill this with remaining space available
        Icon(painter = painterResource(id = R.drawable.jiji), contentDescription = "jumia",modifier = Modifier.clickable { Uri.parse(uri2) })

        Icon(painter = painterResource(id = R.drawable.aliexpress), contentDescription = "jumia",modifier = Modifier.clickable { Uri.parse(uri4) })
        Text("TV PRODUCTS", textAlign = TextAlign.Center,
            modifier = Modifier.weight(1f)) // Fill this with remaining space available
        Icon(painter = painterResource(id = R.drawable.kilimall), contentDescription = "jumia",modifier = Modifier.clickable { Uri.parse(uri5) })

    }
    Row {
        Icon(painter = painterResource(id = R.drawable.alibaba), contentDescription = "jumia",modifier = Modifier.clickable { Uri.parse(uri3) })
        Text("TV PRODUCTS", textAlign = TextAlign.Center,
            modifier = Modifier.weight(1f), color = Color.Red,) // Fill this with remaining space available
        Icon(painter = painterResource(id = R.drawable.glovo), contentDescription = "jumia",modifier = Modifier.clickable { Uri.parse("") })



    }

}

@Preview
@Composable
fun tvprev() {
    tv()
}

