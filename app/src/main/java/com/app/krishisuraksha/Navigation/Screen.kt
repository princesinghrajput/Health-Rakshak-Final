package com.ctuniversity.ctstudentconnectapp.Navigation

sealed class Screen(val route:String) {


    object Home:Screen("HomeScreen")
    object Task:Screen("TaskScreen")
    object BMI:Screen("BMI")
    object Task_item:Screen("Task")
    object Splash:Screen("Splash")

}