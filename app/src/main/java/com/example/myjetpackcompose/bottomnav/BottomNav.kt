package com.example.myjetpackcompose.bottomnav

import android.annotation.SuppressLint
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.myjetpackcompose.ui.theme.Purple40
import com.example.myjetpackcompose.ui.theme.Purple80

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomNav() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = { BottomBar(navController = navController)}
    ) {
        BottomNavGraph(navController = navController)

        
    }
}

@Composable
fun BottomBar(
    navController: NavHostController
){
    val screens = listOf(
        BottomBarScreen.Skripsi,
        BottomBarScreen.Jadwal,
        BottomBarScreen.Nonton,
        BottomBarScreen.Judul,
        BottomBarScreen.Setting
    )
    val navStackBackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navStackBackEntry?.destination
    
    Row(
        modifier = Modifier
            .background(Color.White)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically) {

        screens.forEach { screen->
            if (currentDestination != null) {
                Additem(screen = screen, currentDestination = currentDestination, navController = navController)
            }
        }
    }
}

@Composable
fun RowScope.Additem(
    screen: BottomBarScreen,
    currentDestination: NavDestination,
    navController: NavHostController
){
    val selected = currentDestination?.hierarchy?.any{
        it.route == screen.route
    }

    val background = if (selected) Purple80.copy(alpha = 0.3f) else Color.Transparent
    val contentIcon = if (selected) screen.icon else screen.iconActive
    val contentColor = if (selected) Color.White else Color.Black

    Box(
        modifier = Modifier
            .height(40.dp)
            .clip(CircleShape)
            .background(background)
            .clickable(onClick = {
                navController.navigate(screen.route) {
                    popUpTo(navController.graph.findStartDestination().id)
                    launchSingleTop = true
                }
            })
    ){
        Row(
            modifier =Modifier
                .padding(horizontal = 10.dp, vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Icon(
                painter = painterResource(id = contentIcon),
                contentDescription = "icon",
                )
            AnimatedVisibility(visible = selected) {
                Text(
                    text = screen.title,
                    color = contentColor
                )
                
            }
        }
    }
}

@Composable
@Preview
fun BottomNavPreview(){
    BottomNav()
}