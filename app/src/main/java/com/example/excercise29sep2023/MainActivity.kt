package com.example.excercise29sep2023

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.example.excercise29sep2023.ui.theme.Excercise29Sep2023Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Excercise29Sep2023Theme {
                // A surface container using the 'background' color from the theme
                App()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun App() {
    Surface(
        modifier = Modifier
            .fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        var navController = rememberNavController();
        val drawerState: DrawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
        ModalNavigationDrawer(
            drawerState = drawerState,
            drawerContent = {
                ModalDrawerSheet { NavDrawerContent(navController = navController, drawerState) }
            },
        ) {
            Scaffold(
                topBar = { TopBar(drawerState) },
                bottomBar = { BottonBar() },

                ) {
                    innerPadding -> Column (
                modifier = Modifier.padding(innerPadding)
            ) {
                getNav(navController);
            }
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun AppPreivew() {
    Excercise29Sep2023Theme() {
        App()
    }
}