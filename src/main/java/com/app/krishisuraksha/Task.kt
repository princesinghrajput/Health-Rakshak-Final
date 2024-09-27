package com.app.krishisuraksha

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.navigation.NavHostController
import com.app.krishisuraksha.models.HealthActivity
import com.app.krishisuraksha.models.HealthTip
import com.app.krishisuraksha.ui.theme.md_theme_light_surfaceVariant
import com.app.krishisuraksha.ui.theme.medium_quciksand
import com.app.krishisuraksha.ui.theme.quicksand
import com.ctuniversity.ctstudentconnectapp.Navigation.Screen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Task(navController:NavHostController)
{
    val openAlertDialog = remember { mutableStateOf(false) }
    //dialog(openAlertDialog)

    var selectedItem = remember { mutableIntStateOf(0) }
    val items_name = listOf("Home","BMI","Task","Diseases Info")
    val items_icon = listOf(
        Icons.Filled.Home,
        Icons.Filled.Search,
        Icons.Default.AddCircle,
        Icons.Filled.List)

    Scaffold(topBar = {
        TopAppBar(
            colors = TopAppBarDefaults.mediumTopAppBarColors(
                containerColor = Color.White,
                titleContentColor = Color.Black,
            ),
            title = {
                Text("To Do Health Task")
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
                    .padding(top = it.calculateTopPadding(), bottom = it.calculateBottomPadding()).clickable {
                                                                     openAlertDialog.value = true
                    },
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                LazyColumn{
                    items(10)
                    {

                        task_item(it)
                        Spacer(modifier = Modifier
                            .height(10.dp)
                            .clickable {
                                openAlertDialog.value = true
                            })
                    }
                }

            }
        })

}



@Composable
fun task_item(count:Int)
{



    //val list_heading = listOf("Laundry","Cleaning Products","Energy Use","Food and Beverages")
    val healthActivities = listOf(
        HealthActivity(
            "Daily Exercise Routine",
            "Perform a 30-minute workout or exercise routine each day.",
            "30 minutes of free time to relax or pursue a hobby."
        ),
        HealthActivity(
            "Healthy Eating Challenge",
            "Consume a balanced meal with vegetables and fruits every day for a week.",
            "A healthy recipe book."
        ),
        HealthActivity(
            "Hydration Challenge",
            "Drink at least 8 glasses (64 oz) of water every day for a week.",
            "A stylish reusable water bottle."
        ),
        HealthActivity(
            "Meditation and Mindfulness",
            "Practice meditation or mindfulness for 10 minutes each day for a month.",
            "A subscription to a meditation app."
        ),
        HealthActivity(
            "Regular Sleep Schedule",
            "Maintain a consistent sleep schedule for a week, getting 7-8 hours of sleep each night.",
            "A relaxing scented candle."
        ),
        HealthActivity(
            "Quit Smoking Challenge",
            "Quit smoking or reduce the number of cigarettes smoked daily for a month.",
            "A gift card to a favorite store."
        ),
        HealthActivity(
            "No-Sugar Week",
            "Avoid added sugars in your diet for a week.",
            "A box of healthy snacks."
        ),
        HealthActivity(
            "Walking Challenge",
            "Walk 10,000 steps every day for a week.",
            "A fitness tracker."
        ),
        HealthActivity(
            "Outdoor Adventure",
            "Plan and complete an outdoor adventure like hiking or biking on the weekend.",
            "A picnic set."
        ),
        HealthActivity(
            "Stress Reduction Challenge",
            "Engage in stress-reduction activities like journaling, deep breathing, or taking warm baths for a month.",
            "A spa day or massage voucher."
        )
    )

    val list_photo = listOf(R.drawable.laundry,R.drawable.cleanproducts,R.drawable.lightbulb,R.drawable.fastfood)
    Card(modifier = Modifier
        .fillMaxWidth()
        .clickable {

        }
        .padding(end = 20.dp, bottom = 10.dp, top = 10.dp, start = 20.dp)
        .clickable {


        }, elevation = CardDefaults.cardElevation(5.dp)
        , colors = CardDefaults.cardColors(containerColor = md_theme_light_surfaceVariant),shape = RoundedCornerShape(20.dp)
    ) {

        Row(modifier = Modifier
            .fillMaxWidth()
            .clickable {

            }
            .padding(10.dp), verticalAlignment = Alignment.CenterVertically
        )
        {

            /*Image(painter = painterResource(id = list_photo[count]), contentDescription = null,
            )
            Spacer(modifier = Modifier.width(5.dp))*/
            Column() {


                Text(
                    text = healthActivities[count].task,
                    fontSize = 14.sp,
                    color = Color.Black,
                    fontFamily = quicksand,
                    maxLines = 3,
                    overflow = TextOverflow.Ellipsis
                )
                Spacer(modifier = Modifier.height(5.dp))

                Text(
                    text = healthActivities[count].description,
                    fontSize = 12.sp,
                    color = Color.Black,
                    fontFamily = medium_quciksand,
                    maxLines = 4,
                    overflow = TextOverflow.Ellipsis
                )
            }

        }
    }




}




