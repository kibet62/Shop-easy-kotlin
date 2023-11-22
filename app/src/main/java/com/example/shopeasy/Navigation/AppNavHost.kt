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

    }

}