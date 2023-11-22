package com.example.shopeasy.ui.theme.screens.search

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.shopeasy.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun  searchscreen(navController: NavHostController) {

    val viewModel = viewModel<Mainviewmodel>()
    val searchText by viewModel.searchText.collectAsState()
    val items by viewModel.items.collectAsState()
    val issearching by viewModel.issearching.collectAsState()
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(10.dp)) {
        TextField(value = searchText,
            onValueChange = viewModel::onsearchTextchange,
            modifier = Modifier.fillMaxWidth(),
            placeholder = { Text(text = "search")}
        )
        Spacer(modifier = Modifier.height(20.dp))
        if (issearching){
            Box(modifier = Modifier.fillMaxSize()){
                CircularProgressIndicator(
                    modifier = Modifier.align(Alignment.Center)
                )
            }

        }else {

            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
            ) {
                items(items) { item ->
                    Text(
                        text = "${item.itemname}",
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 10.dp)
                    )

                }

            }

        }
    }
}

@Preview
@Composable
fun searchscreenprev() {
    searchscreen(rememberNavController())
}