package com.app.krishisuraksha

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.semantics.SemanticsProperties.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.app.krishisuraksha.ui.theme.md_theme_light_surfaceVariant
import com.ctuniversity.ctstudentconnectapp.Navigation.Screen
import kotlin.math.pow

@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun BMI(navController:NavHostController) {
    var weight = remember { mutableStateOf(0f) }
    var height = remember { mutableStateOf(0f) }
    var bmi = remember { mutableStateOf(0f) }

    var selectedItem = remember { mutableIntStateOf(0) }
    val items_name = listOf("Home","BMI","Task","Diseases Info")
    val items_icon = listOf(
        Icons.Filled.Home,
        Icons.Filled.Search,
        Icons.Filled.AddCircle,
        Icons.Filled.List)

    Scaffold(topBar = {
        TopAppBar(
            colors = TopAppBarDefaults.mediumTopAppBarColors(
                containerColor = Color.White,
                titleContentColor = Color.Black,
            ),
            title = {
                Text("BMI Calculator")
            }
        )
    },
            bottomBar = {
        NavigationBar( containerColor = md_theme_light_surfaceVariant ) {
            items_name.forEachIndexed { index, item ->
                NavigationBarItem(
                    icon = { Icon(items_icon[index], contentDescription = item) },
                    label = { Text(item) },
                    selected = selectedItem.value == index,
                    onClick = { selectedItem.value = index
                        if(index == 3)
                        {
                            navController.navigate(Screen.Task.route)
                        }
                        else if(index == 1)
                        {
                            navController.navigate(Screen.BMI.route)
                        }else if(index == 0)
                        {
                            navController.navigate(Screen.Home.route)
                        }else if(index == 2)
                        {
                            navController.navigate(Screen.Task_item.route)
                        }
                    }
                )
            }
        }
    },

        content = {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = it.calculateTopPadding()),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                TextField(
                    value = "${weight.value}",
                    onValueChange = {
                        weight.value = it.toFloat()
                    },
                    label = { Text(text = "Weight (kg)") },
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Number,
                        imeAction = androidx.compose.ui.text.input.ImeAction.Done
                    ),

                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                )

                TextField(
                    value = "${height.value}",
                    onValueChange = {
                        height.value = it.toFloat()
                    },
                    label = { Text(text = "Height (cm)") },
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Number,
                        imeAction = androidx.compose.ui.text.input.ImeAction.Done
                    ),

                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                )

                Button(
                    onClick = {
                        // Calculate BMI
                        Log.d("tag","${height.value}  ${weight.value}")
                        val heightInMeters = height.value / 100


                        bmi.value = weight.value / (heightInMeters * heightInMeters)
                            Log.d("tag2","${bmi.value}")

                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                ) {
                    Text(text = "Calculate BMI")
                }

                if (bmi.value > 0) {
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(text = "Your BMI: ${bmi.value}", fontSize = 20.sp)
                }
            }
        })
}



