package com.app.krishisuraksha

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.ctuniversity.ctstudentconnectapp.Navigation.Screen

@Composable
fun Splash(navHostController: NavHostController)
{
    Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {

        Image(painter = painterResource(id = R.drawable.healthcare), contentDescription = "health" )
        Spacer(modifier = Modifier.height(5.dp))
        Text("Healthify")

    }

LaunchedEffect(true)
{
Thread.sleep(1200)
    navHostController.navigate(Screen.Home.route)
}
}