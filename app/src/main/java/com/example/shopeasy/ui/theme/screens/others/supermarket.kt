package com.example.shopeasy.ui.theme.screens.others

import android.net.Uri
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.shopeasy.R


@Composable
fun supermarket() {
    val uri1 = "https://www.jumia.co.ke/catalog/?q=supermarket"
    val uri2 = "https://jiji.co.ke/search?query=supermarket"
    val uri3 = "https://www.alibaba.com/trade/search?spm=a2700.galleryofferlist.pageModule_fy23_pc_search_bar.keydown__Enter&tab=all&searchText=supermarket"
    val uri4 = "https://www.aliexpress.com/w/wholesale-supermarket.html?spm=a2g0o.productlist.search.0"
    val uri5 = "https://www.kilimall.co.ke/new/commoditysearch?q=supermarket"
    Row(
        Modifier
            .fillMaxWidth()
            .height(30.dp)
    ){
        Icon(painter = painterResource(id = R.drawable.jumia_icon), contentDescription = "Back", modifier = Modifier.clickable { Uri.parse(uri1) })
        Text("SUPERMARKET", textAlign = TextAlign.Center,
            modifier = Modifier.weight(1f)) // Fill this with remaining space available
        Icon(painter = painterResource(id = R.drawable.jiji), contentDescription = "jumia",modifier = Modifier.clickable { Uri.parse(uri2) })
        Icon(painter = painterResource(id = R.drawable.alibaba), contentDescription = "jumia",modifier = Modifier.clickable { Uri.parse(uri3) })
        Text("SUPERMARKET", textAlign = TextAlign.Center,
            modifier = Modifier.weight(1f), color = Color.Red,) // Fill this with remaining space available
        Icon(painter = painterResource(id = R.drawable.glovo), contentDescription = "jumia",modifier = Modifier.clickable { Uri.parse("") })
        Icon(painter = painterResource(id = R.drawable.aliexpress), contentDescription = "jumia",modifier = Modifier.clickable { Uri.parse(uri4) })
        Text("SUPERMARKET", textAlign = TextAlign.Center,
            modifier = Modifier.weight(1f)) // Fill this with remaining space available
        Icon(painter = painterResource(id = R.drawable.kilimall), contentDescription = "jumia",modifier = Modifier.clickable { Uri.parse(uri5) })

    }

}