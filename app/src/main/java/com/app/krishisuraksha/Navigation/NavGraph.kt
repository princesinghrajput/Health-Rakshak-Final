package com.ctuniversity.ctstudentconnectapp.Navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.app.krishisuraksha.BMI
import com.app.krishisuraksha.TaskScreen
import com.app.krishisuraksha.HomeScreen
import com.app.krishisuraksha.MainActivity
import com.app.krishisuraksha.Splash
import com.app.krishisuraksha.Task


@Composable
fun NavGraph(navcontroller: NavHostController, mainActivity: MainActivity)
{
    NavHost(navController = navcontroller, startDestination = Screen.Splash.route)
    {



        composable(route = Screen.Home.route)
        {
            HomeScreen(navcontroller)
        }

        composable(route = Screen.Task.route)
        {
            TaskScreen(navcontroller)

        }

        composable(route = Screen.BMI.route)
        {
           BMI(navcontroller)

        }
        composable(route = Screen.Task_item.route)
        {
            Task(navcontroller)

        }
        
        composable(route = Screen.Splash.route)
        {
            Splash(navHostController = navcontroller)
        }


    }
}