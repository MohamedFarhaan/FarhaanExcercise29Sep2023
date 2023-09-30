package com.example.excercise29sep2023

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon

import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(drawerState: DrawerState) {
    var scope = rememberCoroutineScope();
    var context: Context = LocalContext.current;
    TopAppBar(
        title = { Text(text = "Information", Modifier.padding(10.dp, 0.dp)) },
        navigationIcon = { IconButton(onClick = { scope.launch { drawerState.open() } }) {
            Icon(imageVector = Icons.Default.Menu, contentDescription = "Menu")
        } },
        actions = {
            IconButton(onClick = {
                    Toast.makeText(context,"Option not yet available", Toast.LENGTH_SHORT).show()
                }) {
                Icon(imageVector = Icons.Default.Favorite, contentDescription = "Activity")
            }
        },

    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottonBar() {
    var context: Context = LocalContext.current
    BottomAppBar(
        tonalElevation = 12.dp,
        actions = {
            Row (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp, 0.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                IconButton(onClick = {Toast.makeText(context,"Option not yet available", Toast.LENGTH_SHORT).show()}) {
                    Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back")
                }
                IconButton(onClick = {Toast.makeText(context,"Option not yet available", Toast.LENGTH_SHORT).show()}) {
                    Icon(imageVector = Icons.Default.Add, contentDescription = "Add")
                }
                IconButton(onClick = {Toast.makeText(context,"Option not yet available", Toast.LENGTH_SHORT).show()}) {
                    Icon(imageVector = Icons.Default.Notifications, contentDescription = "Notification")
                }
            }

        }
    )
}

@Preview(showBackground = true)
@Composable
fun BottonBarPreview() {
    BottonBar()
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun getNav(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "screen1") {
        composable("screen1") {
            Screen1()
        }
        composable("screen2") {
            Screen2()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavDrawerContent(navController: NavController, drawerState: DrawerState) {
    var scope = rememberCoroutineScope();
    Column(modifier = Modifier
        .fillMaxHeight()
        .fillMaxWidth(0.8f)) {
        Column(modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.25f),
            verticalArrangement = Arrangement.Center) {
                Image(painter = painterResource(id = R.drawable.image_menu), contentDescription = "Menu",
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop)
        }
        Column(modifier = Modifier
            .fillMaxWidth()) {
            NavigationDrawerItem(label = { Text(text = "Food",
                Modifier
                    .padding(25.dp, 0.dp)
                    .fillMaxWidth(), textAlign = TextAlign.Center) },
                selected = navController.currentBackStackEntry?.destination?.route.equals("screen1"),
                onClick = { navController.navigate("screen1"); scope.launch() { drawerState.close() } },
                modifier = Modifier.padding(25.dp, 12.dp))

            NavigationDrawerItem(label = { Text(text = "Wonders of world",
                Modifier
                    .padding(25.dp, 0.dp)
                    .fillMaxWidth(), textAlign = TextAlign.Center) },
                selected = navController.currentBackStackEntry?.destination?.route.equals("screen2"),
                onClick = { navController.navigate("screen2"); scope.launch() { drawerState.close() } },
                modifier = Modifier.padding(25.dp, 12.dp))
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun NavDrawerContentPreview() {
    var navController = rememberNavController();
    var drawerState = rememberDrawerState(initialValue = DrawerValue.Closed);
    NavDrawerContent(navController, drawerState)
}