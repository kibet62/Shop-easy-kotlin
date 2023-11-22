package com.example.shopeasy.ui.theme.screens.profile

import android.net.Uri
import android.text.style.BackgroundColorSpan
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberImagePainter
import com.example.shopeasy.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun  Profilescreen(navController: NavHostController) {

    val notification = rememberSaveable { mutableStateOf("") }
    if (notification.value.isNotEmpty()) {
        Toast.makeText(LocalContext.current, notification.value, Toast.LENGTH_LONG).show()
        notification.value = ""
    }

    var name by rememberSaveable { mutableStateOf("default name") }
    var usernane by rememberSaveable { mutableStateOf("default username") }

    val imageuri = rememberSaveable { mutableStateOf("") }
    val painter = rememberImagePainter(
        if (imageuri.value.isEmpty())
            R.drawable.baseline_person_outline_24
        else
            imageuri.value

    )

    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ){
            uri: Uri? ->
        uri?.let { imageuri.value = it.toString() }
    }


    Column(modifier = Modifier
        .verticalScroll(rememberScrollState())
        .padding(10.dp)) {


        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
            horizontalArrangement = Arrangement.SpaceBetween) {
            Text(
                text = "Cancelled",
                modifier = Modifier
                    .clickable { notification.value = "Cancel" })
            Text(text = "Save",
                modifier = Modifier
                    .clickable { notification.value = "profile updated" })

        }


    Column(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Card(
            shape = CircleShape,
            modifier = Modifier
                .padding(10.dp)
                .size(100.dp)
        ) {
            Image(
                painter = painter,
                contentDescription = null,
                modifier = Modifier
                    .wrapContentSize()
                    .clickable { launcher.launch("image/^*") },
                contentScale = ContentScale.Crop
            )

        }
        Text(text = "Change profile photo")

    }
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(start = 5.dp, end = 5.dp),
            verticalAlignment = Alignment.CenterVertically) {

            Text(text = "name", modifier = Modifier.width(100.dp))
            TextField(value = name,
                onValueChange = { name= it},
                colors = TextFieldDefaults.textFieldColors(
                    textColor = Color.Black)
            )

        }
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(start = 5.dp, end = 5.dp),
            verticalAlignment = Alignment.CenterVertically) {

            Text(text = "username", modifier = Modifier.width(100.dp))
            TextField(value = usernane,
                onValueChange = { usernane= it},
                colors = TextFieldDefaults.textFieldColors(
                    textColor = Color.Black)
            )

        }

    }
}



@Preview
@Composable
fun Profilescreenprevie() {
    Profilescreen(rememberNavController())

}

