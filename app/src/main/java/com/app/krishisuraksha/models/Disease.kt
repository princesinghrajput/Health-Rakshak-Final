package com.app.krishisuraksha.models

data class Disease(
    val title: String,
    val description: String,
    val symptoms: List<String>,
    val precautions: List<String>
)