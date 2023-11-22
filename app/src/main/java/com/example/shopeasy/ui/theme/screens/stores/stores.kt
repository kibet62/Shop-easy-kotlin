package com.example.shopeasy.ui.theme.screens.stores




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
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController


@Composable
fun  ElevatedBox(navController: NavHostController) {

    val uri1 = "https://www.jumia.co.ke/"
    val uri2 = "https://jiji.co.ke/home-garden"
    val uri3 = "https://www.kilimall.co.ke/new/flash-sales?gad_source=1&gclid=CjwKCAiAx_GqBhBQEiwAlDNAZsbsvr_bajFyIBKNEjm9OejP3EjLHgw9c2JYVqilrEP3aJpNzp3W4RoClY0QAvD_BwE"
    val uri4 = "https://best.aliexpress.com/?src=google&albch=fbrnd&acnt=304-410-9721&albcp=2068664807&albag=79246744747&slnk=&trgt=aud-529380664054%3Akwd-14802285088&plac=&crea=619778398989&netw=g&device=c&mtctp=e&memo1=&albbt=Google_7_fbrnd&albagn=888888&isSmbActive=false&isSmbAutoCall=false&needSmbHouyi=false&gad_source=1&gclid=CjwKCAiAx_GqBhBQEiwAlDNAZm4o-JoVYBg81TnddmN_0yZsq9h7hvR-jHsbi-FKvqk9aMwC3o4OXhoCguAQAvD_BwE&aff_fcid=cde3832f56f5498d9a853f33878f1944-1700596035647-02509-UneMJZVf&aff_fsk=UneMJZVf&aff_platform=aaf&sk=UneMJZVf&aff_trace_key=cde3832f56f5498d9a853f33878f1944-1700596035647-02509-UneMJZVf&terminal_id=bc74ce64ca584133abab64c9e2e1a027&afSmartRedirect=y"
    val uri5 = "https://www.alibaba.com/?src=sem_ggl&field=UG&from=sem_ggl&cmpgn=9922923274&adgrp=97780322862&fditm=&tgt=kwd-14739453&locintrst=&locphyscl=9073678&mtchtyp=e&ntwrk=g&device=c&"
    Column(
        modifier = Modifier
            .padding(16.dp)
            .clickable { },

        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Row(modifier = Modifier.clickable {  }) {

            BoxWithName(name = "JUMIA", color = Color.Yellow,parse  = Uri.parse(uri1))
            BoxWithName(name = "GLOVO", color = Color.White,parse = Uri.parse(""))
        }
        Row {
            BoxWithName(name = "JIJI", color = Color.Green,parse = Uri.parse(uri2))
            BoxWithName(name = "ALIBABA", color = Color.Magenta,parse = Uri.parse(uri3))

        }
        Row {
            BoxWithName(name = "ALIEXPRESS", color = Color.Red,parse = Uri.parse(uri4))
            BoxWithName(name = "KILIMALL", color = Color.Blue,parse = Uri.parse(uri5))
        }

    }
}

@Composable
fun BoxWithName(name: String, color: Color, parse: Uri) {

    val uri1 = "https://www.jumia.co.ke/automobile/"
    val uri2 = "https://jiji.co.ke/home-garden?query=automobile"
    val uri3 = "https://www.alibaba.com/trade/search?spm=a2700.product_home_newuser.home_new_user_first_screen_fy23_pc_search_bar.associationItem_pos_0&tab=all&searchText=automobile"
    val uri4 = "https://www.aliexpress.com/w/wholesale-automobile.html?spm=a2g0o.productlist.search.0"
    val uri5 = "https://www.kilimall.co.ke/new/commoditysearch?q=automobile"
    val handler = LocalUriHandler.current
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
            Text(text = name, fontSize = 24.sp)
        }
        
    }

}


@Preview
@Composable
fun ElevatedBoxPreview() {
    ElevatedBox(rememberNavController())
}
