package com.app.krishisuraksha.common

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ContentAlpha
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.krishisuraksha.models.Disease
import com.app.krishisuraksha.ui.theme.md_theme_light_surfaceVariant
import com.app.krishisuraksha.ui.theme.medium_quciksand

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Cards(data:Disease) {

    var expanded_state = remember {
        mutableStateOf(false)
    }

    val rotate = animateFloatAsState(targetValue = if (expanded_state.value) 180f else 0f)

    Card(shape = RoundedCornerShape(10.dp),colors = CardDefaults.cardColors(containerColor = md_theme_light_surfaceVariant),modifier = Modifier
        .fillMaxWidth()
        .padding(12.dp)
        .animateContentSize(
            animationSpec =
            tween(300, easing = LinearOutSlowInEasing)
        ), onClick = {
        expanded_state.value = !expanded_state.value
    }) {
        Column(
            modifier = androidx.compose.ui.Modifier
                .fillMaxWidth()
                .padding(12.dp)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically)
            {
                Text(
                    data.title,
                    color = Color.Black,
                    fontWeight = FontWeight.Normal,
                    fontFamily = medium_quciksand,
                    fontSize = 18.sp,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.weight(6f)
                )

                IconButton(
                    onClick = { expanded_state.value = !expanded_state.value },
                    modifier = Modifier
                        .alpha(ContentAlpha.medium)
                        .weight(1f)
                        .rotate(rotate.value),
                ) {
                    Icon(
                        imageVector = Icons.Default.ArrowDropDown,
                        contentDescription = "Drop Down"
                    )
                }
            }

            if (expanded_state.value) {

                Text(
                    "Discription",
                    color = Color.Black,
                    fontWeight = FontWeight.Normal,
                    fontFamily = medium_quciksand,
                    fontSize = 18.sp,

                )

                Spacer(modifier = Modifier.height(2.dp))

                    Text(
                        data.description,
                        color = Color.Black,
                        fontWeight = FontWeight.Normal,
                        fontFamily = medium_quciksand,
                        fontSize = 16.sp,

                        )

                    Spacer(modifier = Modifier.height(10.dp))

                Text(
                    "Symptoms",
                    color = Color.Black,
                    fontWeight = FontWeight.Normal,
                    fontFamily = medium_quciksand,
                    fontSize = 18.sp,

                    )

                Spacer(modifier = Modifier.height(2.dp))

                data.symptoms.forEach{
                    Text(
                        it,
                        color = Color.Black,
                        fontWeight = FontWeight.Normal,
                        fontFamily = medium_quciksand,
                        fontSize = 16.sp,

                        )
                }



                Spacer(modifier = Modifier.height(10.dp))


                Text(
                    "Precautions",
                    color = Color.Black,
                    fontWeight = FontWeight.Normal,
                    fontFamily = medium_quciksand,
                    fontSize = 18.sp,

                    )

                Spacer(modifier = Modifier.height(2.dp))

                data.precautions.forEach{
                    Text(
                        it,
                        color = Color.Black,
                        fontWeight = FontWeight.Normal,
                        fontFamily = medium_quciksand,
                        fontSize = 16.sp,

                        )
                }

                Spacer(modifier = Modifier.height(10.dp))


            }
        }
    }
}