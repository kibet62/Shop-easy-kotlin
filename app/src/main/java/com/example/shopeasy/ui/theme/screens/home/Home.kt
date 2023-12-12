package com.example.shopeasy.ui.theme.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.shopeasy.Navigation.ROUTE_HOME
import com.example.shopeasy.Navigation.ROUTE_LOGIN
import com.example.shopeasy.Navigation.ROUTE_PROFILE
import com.example.shopeasy.Navigation.ROUTE_REGISTER
import com.example.shopeasy.Navigation.ROUTE_SEARCH
import com.example.shopeasy.Navigation.ROUTE_STORES
import com.example.shopeasy.R



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun  homescreen(navController: NavHostController) {
    Column(horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        ElevatedCard(
            elevation = CardDefaults.cardElevation(
                defaultElevation = 6.dp
            ),
            modifier = Modifier
                .size(width = 500.dp, height = 40.dp)
                .background(color = Color.Green,)

        ) {
            Text(
                text = "WELCOME USER TO YOUR ALL IN ONE ONLINE SHOPPING SITES!",
                textAlign = TextAlign.Center,
                color = Color.Black,


                )
        }



        Text(
            text = "Welcome user ",
            color = Color.Green,
            fontFamily = FontFamily.Cursive,
            fontSize = 30.sp
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(onClick = { navController.navigate(ROUTE_REGISTER) }, modifier = Modifier.clickable {}) {
                Text(text = "Register")

            }
            Button(onClick = { navController.navigate(ROUTE_LOGIN) }, modifier = Modifier.clickable {}) {
                Text(text = "Sign in")

            }


        }

            Spacer(modifier = Modifier.height(70.dp))


            Image(
                painter = painterResource(id = R.drawable.joker),
                contentDescription = " joker",
                modifier = Modifier
                    .fillMaxWidth()

            )





            Scaffold(
                bottomBar = {
                    BottomAppBar(
                        actions = {
                            IconButton(onClick = { /* do something */ navController.navigate(
                                ROUTE_HOME) }) {
                                Icon(
                                    Icons.Filled.Home,
                                    contentDescription = "Localized description"
                                )
                            }
                            IconButton(onClick = { /* do something */navController.navigate(ROUTE_SEARCH)  }) {
                                Icon(
                                    Icons.Filled.Search,
                                    contentDescription = "Localized description",
                                )
                            }
                            IconButton(onClick = { /* do something */navController.navigate(ROUTE_STORES)  }) {
                                Icon(
                                    Icons.Filled.List,
                                    contentDescription = "Localized description",
                                )
                            }
                            IconButton(onClick = { /* do something */navController.navigate(ROUTE_PROFILE) }) {
                                Icon(
                                    Icons.Filled.AccountCircle,
                                    contentDescription = "Localized description",
                                )
                            }


                        },

                        )
                },
            ) { innerPadding ->
                Text(
                    modifier = Modifier.padding(innerPadding),
                    text = ""
                )
            }
        }

    }


@Preview
@Composable
fun Profilescreenprev() {
    homescreen(rememberNavController())

}




