package com.example.myjetpackcompose.bottomnav

import android.annotation.SuppressLint
import android.graphics.ColorMatrix
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
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
import com.example.myjetpackcompose.screen.component.CustomTopSkripsi
import com.example.myjetpackcompose.ui.theme.ColorIconBar
import com.example.myjetpackcompose.ui.theme.Purple40
import com.example.myjetpackcompose.ui.theme.Purple80

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun BottomNav() {
    val navController = rememberNavController()

    Scaffold(
        topBar ={ CustomTopSkripsi(navController) },
        bottomBar = { BottomBar(navController = navController)}
    ) {
        BottomNavGraph(navController = navController, it)

        
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
    Card(
        shape = RoundedCornerShape(10.dp),
        elevation = 6.dp
    ) {

        NavigationBar(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    color = Color.Transparent,
                    shape = RoundedCornerShape(16.dp)
                )
//                .shadow(
//                elevation = 1.dp,
//                ambientColor = Color(0x3C000000),
//                shape = RoundedCornerShape(16.dp)
//                    )
                .height(100.dp)
                .padding(4.dp),
            containerColor = Color.Transparent,
            tonalElevation = 4.dp
        ) {
            screens.forEach { screen->
                if (currentDestination != null) {
                    Additem(screen = screen, currentDestination = currentDestination, navController = navController)
                }
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
    val selected = currentDestination.hierarchy.any{
        it.route == screen.route
    }

    val background = if (selected) Purple80.copy(alpha = 0.3f) else Color.Transparent
    val contentIcon = if (!selected) screen.icon else screen.iconActive


    NavigationBarItem(
    label = {
        Text(
            text = screen.title,
            textAlign = TextAlign.Center,
        )
    },
    icon ={
        Icon(
            painter = painterResource(id = contentIcon),
            contentDescription = screen.title,
            tint = ColorIconBar

        )
    },
        selected = selected,
        onClick ={
            navController.navigate(screen.route) {
                popUpTo(navController.graph.findStartDestination().id)
                launchSingleTop = true
            }
        }

)

}