package com.example.excercise29sep2023

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DrawerState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun Screen2() {
    val locations = remember {
        mutableStateOf(arrayOf<Location>(
            Location("Tajmahal", R.drawable.image_tajmahal),
            Location("Great Wall of China",R.drawable.image_china_wall),
            Location("Statue of Liberty",R.drawable.image_statue_of_liberty)
        ))
    }
    LazyColumn {
        items(locations.value) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .padding(12.dp),
                elevation = CardDefaults.cardElevation(defaultElevation = 10.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxSize(),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(text = it.name, modifier = Modifier.weight(1f).fillMaxWidth(), textAlign = TextAlign.Center)
                    Image(painter = painterResource(id = it.image),
                        contentDescription = it.name,
                        Modifier.weight(1f).fillMaxSize(),
                        contentScale = ContentScale.Crop
                        )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Screen2Preview() {
    Screen2()
}

data class Location(val name: String, val image: Int);