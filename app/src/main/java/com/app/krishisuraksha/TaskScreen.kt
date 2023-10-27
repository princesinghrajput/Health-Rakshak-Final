package com.app.krishisuraksha

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.app.krishisuraksha.common.Cards
import com.app.krishisuraksha.models.Disease
import com.app.krishisuraksha.ui.theme.md_theme_light_surfaceVariant
import com.ctuniversity.ctstudentconnectapp.Navigation.Screen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TaskScreen(navController:NavHostController)
{
// info screen
    var selectedItem = remember { mutableIntStateOf(0) }
    val items_name = listOf("Home","BMI","Task","Diseases Info")
    val items_icon = listOf(
        Icons.Filled.Home,
        Icons.Filled.Search,
        Icons.Filled.AddCircle,
        Icons.Filled.List)

    val diseases = listOf(
        Disease(
            "Diabetes",
            "Early diabetes diagnosis is essential for managing and controlling this chronic medical condition...",
            listOf(
                "Frequent Urination",
                "Excessive Thirst",
                "Extreme Hunger",
                "Unexplained Weight Loss",
                "Fatigue",
                "Blurred Vision",
                "Slow Wound Healing",
                "Tingling or Numbness"
            ),
            listOf(
                "Regular Check-ups",
                "Healthy Diet",
                "Regular Exercise",
                "Stress Management",
                "Medication Compliance",
                "Blood Sugar Monitoring",
                "Avoid Smoking and Excessive Alcohol"
            )
        ),
        Disease(
            "Liver Disease ",
            "Predicting liver diseases is crucial for early intervention and prevention...",
            listOf(
                "Jaundice",
                "Abdominal Pain",
                "Fatigue",
                "Swelling",
                "Nausea and Vomiting",
                "Dark Urine",
                "Pale Stools",
                "Loss of Appetite"
            ),
            listOf(
                "Healthy Diet",
                "Regular Exercise",
                "Vaccinations",
                "Safe Sex",
                "Medication Management",
                "Limit Alcohol",
                "Regular Check-ups"
            )
        ),
        Disease(
            "Malaria",
            "Timely detection of malaria is essential for effective treatment and to prevent severe complications...",
            listOf(
                "Fever",
                "Headache",
                "Fatigue",
                "Muscle and Joint Pain",
                "Nausea and Vomiting",
                "Anemia",
                "Enlarged Spleen"
            ),
            listOf(
                "Mosquito Repellent",
                "Bed Nets",
                "Antimalarial Medication",
                "Diagnostics",
                "Drain Standing Water"
            )
        ),
        Disease(
            "Pneumonia",
            "Early detection of pneumonia is crucial for prompt treatment and to prevent complications...",
            listOf(
                "Cough",
                "Fever",
                "Shortness of Breath",
                "Chest Pain",
                "Fatigue",
                "Confusion (in older adults)",
                "Sputum Production",
                "Bluish Lips or Fingernails"
            ),
            listOf(
                "Vaccination",
                "Hand Hygiene",
                "Respiratory Etiquette",
                "Avoid Smoking and Secondhand Smoke",
                "Prompt Treatment"
            )
        ),Disease(
                "Common Cold",
        "The common cold is a viral infection of the nose and throat...",
        listOf(
            "Runny or Stuffy Nose",
            "Sneezing",
            "Coughing",
            "Sore Throat",
            "Mild Headache",
            "Fatigue",
            "Watery Eyes"
        ),
        listOf(
            "Rest and Hydration",
            "Over-the-Counter Medications",
            "Good Hygiene",
            "Avoid Close Contact with Infected Individuals"
        )
    ),
    Disease(
        "Influenza (Flu)",
        "Influenza, commonly known as the flu, is a contagious respiratory illness...",
        listOf(
            "Fever",
            "Cough",
            "Sore Throat",
            "Muscle and Body Aches",
            "Fatigue",
            "Headache",
            "Runny or Stuffy Nose",
            "Chills"
        ),
        listOf(
            "Flu Vaccination",
            "Rest and Hydration",
            "Antiviral Medications (if prescribed)",
            "Good Respiratory Hygiene",
            "Isolation to Prevent Spread"
        )
    )
    )
    Scaffold(

            topBar = {
                TopAppBar(
                    colors = TopAppBarDefaults.mediumTopAppBarColors(
                        containerColor = Color.White,
                        titleContentColor = Color.Black,
                    ),
                    title = {
                        Text("Common Diseases")
                    }
                )
            },bottomBar = {
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
                                }
                                else if(index == 0)
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
            }


        ,content = {

            Column(modifier = Modifier
                .fillMaxSize()

                .background(color = Color.White)
                .padding(top = it.calculateTopPadding())) {

                LazyColumn(content = {

                    items(diseases)
                    {
                        Cards(data = it)
                    }
                })



            }

        }
    )




}