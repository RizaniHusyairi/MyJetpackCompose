package com.example.myjetpackcompose.bottomnav

import android.annotation.SuppressLint
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
        modifier = Modifier.shadow(
            elevation = 4.dp,
            ambientColor = Color(0x3C000000),
            shape = RoundedCornerShape(16.dp)
        )
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {

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
    val contentIcon = if (!selected) screen.icon else screen.iconActive

    Box(
        modifier = Modifier
            .height(60.dp).width(60.dp)
            .background(background)
            .clickable(onClick = {
                navController.navigate(screen.route) {
                    popUpTo(navController.graph.findStartDestination().id)
                    launchSingleTop = true
                }
            }),
        contentAlignment = Alignment.Center
    ){
        Column(
            modifier =Modifier
                .padding(horizontal = 10.dp, vertical = 8.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            Icon(
                painter = painterResource(id = contentIcon),
                contentDescription = "icon",
                tint = Color(0xff003B72)
                )
            Text(
                text = screen.title,
                color = Color.Black,
                fontSize = 9.sp,
                textAlign = TextAlign.Center
                )
                

        }
    }
}

@Composable
@Preview
fun BottomNavPreview(){
    BottomNav()
}