package com.app.krishisuraksha

import CustomComponent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.app.krishisuraksha.models.HealthTip
import com.app.krishisuraksha.ui.theme.md_theme_dark_primary
import com.app.krishisuraksha.ui.theme.md_theme_light_inversePrimary
import com.app.krishisuraksha.ui.theme.md_theme_light_primaryContainer
import com.app.krishisuraksha.ui.theme.md_theme_light_secondaryContainer
import com.app.krishisuraksha.ui.theme.md_theme_light_surface
import com.app.krishisuraksha.ui.theme.md_theme_light_surfaceTint
import com.app.krishisuraksha.ui.theme.md_theme_light_surfaceVariant
import com.app.krishisuraksha.ui.theme.medium_quciksand
import com.app.krishisuraksha.ui.theme.quicksand
import com.ctuniversity.ctstudentconnectapp.Navigation.Screen
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavHostController)
{
    var selectedItem = remember { mutableIntStateOf(0) }
    val items_name = listOf("Home","BMI","Task","Diseases Info")
    val items_icon = listOf(Icons.Filled.Home,Icons.Filled.Search,Icons.Filled.AddCircle,Icons.Filled.List)

    Scaffold(

        floatingActionButtonPosition = FabPosition.End,
        /*floatingActionButton = {
            FloatingActionButton(onClick = { /*TODO*/ }, containerColor = md_theme_light_surfaceVariant) {
                Column() {
                    Icon(painterResource(id = R.drawable.baseline_message_24), contentDescription = "item", tint = Color.Black)
                    Text(
                        text = "Chat",
                        fontSize = 10.sp,

                        textAlign = TextAlign.Start,
                        color = Color.Black

                    )
                }


            }
        }*/

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
        } , content = {
            Column(modifier = Modifier
                .fillMaxSize()

                .background(color = Color.White)
                .padding(bottom = it.calculateBottomPadding(), top = 10.dp)) {

                Surface(modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp, end = 10.dp)
                    .height(100.dp), color = md_theme_light_surfaceVariant
                    , shape = RoundedCornerShape(20.dp)
                ) {



                    Row(verticalAlignment =  Alignment.Top ) {




                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .weight(0.8f)
                        ) {


                            Spacer(modifier = Modifier.height(10.dp))
                            Text(
                                text = "Hello,",
                                fontSize = 22.sp,
                                textAlign = TextAlign.Start,
                                color = Color.Black,
                                fontFamily = medium_quciksand,
                                modifier = Modifier.padding(start = 15.dp)
                            )

                            Spacer(modifier = Modifier.height(5.dp))

                            Text(
                                "Manmeet Singh",
                                fontSize = 18.sp,
                                textAlign = TextAlign.Start,
                                color = Color.Black,
                                fontFamily = medium_quciksand,
                                modifier = Modifier.padding(start = 15.dp)
                            )

                        }


                    }
                }



                // tips part



                    // tip card
                LazyColumn(verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally,content = {

                    item{

                        Spacer(modifier = Modifier.height(10.dp))

                        CustomComponent()

                        Spacer(modifier = Modifier.height(10.dp))
                    }

                    item {
                        Text(
                            "Tips for better health",
                            fontSize = 18.sp,
                            textAlign = TextAlign.Start,
                            color = Color.Black,
                            fontFamily = medium_quciksand,
                            modifier = Modifier.padding(start = 15.dp)
                        )

                        Spacer(modifier = Modifier.height(10.dp))
                    }



                    items(6)
                    {

                        tips(it)
                        Spacer(modifier = Modifier.height(10.dp))
                    }
                })




                
            }
        }
    ) 
}


@Composable
fun tips(count:Int)
{

    //val list_heading = listOf("Laundry","Cleaning Products","Energy Use","Food and Beverages")
    val homeHealthTips = listOf(
        HealthTip(
            "Stay Hydrated",
            "Drink plenty of water throughout the day to keep your body well-hydrated. Staying hydrated helps maintain proper bodily functions and promotes overall health."
        ),
        HealthTip(
            "Eat Balanced Meals",
            "Consume a variety of foods that include fruits, vegetables, lean proteins, and whole grains. A balanced diet provides essential nutrients for your well-being."
        ),
        HealthTip(
            "Get Adequate Sleep",
            "Ensure you get 7-8 hours of quality sleep each night. Adequate sleep is vital for physical and mental health, and it helps your body recover and recharge."
        ),
        HealthTip(
            "Stay Active",
            "Incorporate regular physical activity into your routine. Even a short daily walk can improve your fitness and boost your mood."
        ),
        HealthTip(
            "Practice Stress Management",
            "Learn stress-reduction techniques such as deep breathing, meditation, or yoga. Managing stress is crucial for your mental and physical well-being."
        ),
        HealthTip(
            "Maintain Good Hygiene",
            "Regularly wash your hands, maintain oral hygiene, and take showers to prevent the spread of germs and maintain personal cleanliness."
        )
    )

            val list_photo = listOf(R.drawable.laundry,R.drawable.cleanproducts,R.drawable.lightbulb,R.drawable.fastfood)
    Card(modifier = Modifier
        .fillMaxWidth()
        .padding(end = 20.dp, bottom = 10.dp, top = 10.dp, start = 20.dp)
        .clickable {


        }, elevation = CardDefaults.cardElevation(5.dp)
        , colors = CardDefaults.cardColors(containerColor = md_theme_light_surfaceVariant),shape = RoundedCornerShape(20.dp)
    ) {

        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp), verticalAlignment = Alignment.CenterVertically
        )
        {

            /*Image(painter = painterResource(id = list_photo[count]), contentDescription = null,
            )
            Spacer(modifier = Modifier.width(5.dp))*/
            Column() {


                Text(
                    text = homeHealthTips[count].title,
                    fontSize = 14.sp,
                    color = Color.Black,
                    fontFamily = quicksand,
                    maxLines = 3,
                    overflow = TextOverflow.Ellipsis
                )
                Spacer(modifier = Modifier.height(5.dp))

                Text(
                    text = homeHealthTips[count].description,
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