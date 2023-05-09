package com.example.myjetpackcompose.screen.component

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.myjetpackcompose.bottomnav.BottomBarScreen
import com.example.myjetpackcompose.font.customFontPoetsen
import com.example.myjetpackcompose.ui.theme.TitleColor


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTopSkripsi(navController: NavHostController){
    val screens = listOf(
        BottomBarScreen.Skripsi,
        BottomBarScreen.Jadwal,
        BottomBarScreen.Nonton,
        BottomBarScreen.Judul,
        BottomBarScreen.Setting
    )
    val navStackBackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navStackBackEntry?.destination
    var title:String = ""
    screens.forEach{ screen ->
        if (currentDestination?.hierarchy?.any{
                it.route == screen.route
            } == true){
            title = screen.title
        }


    }
    Box(modifier = Modifier
        .height(100.dp)
        .fillMaxWidth()
    ){
        TopAppBar(
            modifier = Modifier.padding(top = 24.dp, bottom = 10.dp),
            title = {
                Text(
                    text = title,
                    fontFamily = customFontPoetsen,
                    color = TitleColor
                )
            },
            actions = {
                NotifAction()
            }
        )
    }
}

@Composable
fun NotifAction(){
    val context = LocalContext.current
    IconButton(onClick = {
        Toast.makeText(context,"Notification", Toast.LENGTH_SHORT).show()
    }) {
        Icon(
            imageVector = Icons.Outlined.Notifications,
            contentDescription = "Notification",
            tint = Color(0xff747474)
        )

    }
}