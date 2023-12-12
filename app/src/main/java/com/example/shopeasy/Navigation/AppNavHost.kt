package com.example.shopeasy.Navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.shopeasy.ui.theme.screens.Register.RegisterScreen
import com.example.shopeasy.ui.theme.screens.home.homescreen
import com.example.shopeasy.ui.theme.screens.login.LoginScreen
import com.example.shopeasy.ui.theme.screens.others.Automobile
import com.example.shopeasy.ui.theme.screens.others.audio
import com.example.shopeasy.ui.theme.screens.others.books
import com.example.shopeasy.ui.theme.screens.others.computing
import com.example.shopeasy.ui.theme.screens.others.fasion
import com.example.shopeasy.ui.theme.screens.others.food
import com.example.shopeasy.ui.theme.screens.others.gaming
import com.example.shopeasy.ui.theme.screens.others.gardening
import com.example.shopeasy.ui.theme.screens.others.health
import com.example.shopeasy.ui.theme.screens.others.home
import com.example.shopeasy.ui.theme.screens.others.kitchen
import com.example.shopeasy.ui.theme.screens.others.phones
import com.example.shopeasy.ui.theme.screens.others.sporting
import com.example.shopeasy.ui.theme.screens.others.supermarket
import com.example.shopeasy.ui.theme.screens.others.tv
import com.example.shopeasy.ui.theme.screens.profile.Profilescreen
import com.example.shopeasy.ui.theme.screens.search.searchscreen
import com.example.shopeasy.ui.theme.screens.stores.ElevatedBox
import com.example.shopeasy.ui.theme.screens.webview.webviewscreen


@Composable
fun AppNavHost(modifier: Modifier = Modifier, navController: NavHostController = rememberNavController(), startDestination:String= ROUTE_LOGIN) {

    NavHost(navController = navController, modifier=modifier, startDestination = startDestination ){
        composable(ROUTE_LOGIN){
            LoginScreen(navController)
        }
        composable(ROUTE_REGISTER){
            RegisterScreen(navController)
        }
        composable(ROUTE_HOME){
            homescreen(navController)
        }
        composable(ROUTE_PROFILE){
            Profilescreen(navController)
        }
        composable(ROUTE_SEARCH){
            searchscreen(navController)
        }
        composable(ROUTE_WEBVIEW){
            webviewscreen(navController)
        }
        composable(ROUTE_STORES){
            ElevatedBox(navController)
        }
        composable(ROUTE_TV){
            tv(navController)
        }
        composable(ROUTE_GAMING){
            gaming(navController)
        }
        composable(ROUTE_COMPUTING){
            computing(navController)
        }
        composable(ROUTE_FASHION){
            fasion(navController)
        }
        composable(ROUTE_FOOD){
            food(navController)
        }
        composable(ROUTE_AUDIO){
            audio(navController)
        }
        composable(ROUTE_BOOKS){
            books(navController)
        }
        composable(ROUTE_AUTOMOBILE){
            Automobile(navController)
        }
        composable(ROUTE_GARDENING){
            gardening(navController)
        }
        composable(ROUTE_HEALTH){
            health(navController)
        }
        composable(ROUTE_KITCHEN){
            kitchen(navController)
        }
        composable(ROUTE_OFFICE){
            home(navController)
        }
        composable(ROUTE_SUPERMARKET){
            supermarket(navController)
        }
        composable(ROUTE_SPORTING){
            sporting(navController)
        }
        composable(ROUTE_PHONES){
            phones(navController)
        }

    }

}