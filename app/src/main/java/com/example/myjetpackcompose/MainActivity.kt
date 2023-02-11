package com.example.myjetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.rounded.AddCircle
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.myjetpackcompose.data.BottomNavItem


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ScaffoldExample()
//            Column(
//                modifier = Modifier.fillMaxSize().padding(16.dp)
//            ) {
//                TopAppBar()
//            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScaffoldExample(){
    val materialBlue100 = Color(0xFF609EA2)
    val bottomNavItems = listOf(
        BottomNavItem(
            name = "Home",
            route = "home",
            icon = Icons.Rounded.Home,
        ),
        BottomNavItem(
            name = "Create",
            route = "add",
            icon = Icons.Rounded.AddCircle,
        ),
        BottomNavItem(
            name = "Settings",
            route = "settings",
            icon = Icons.Rounded.Settings,
        ),
    )
    Scaffold(
        topBar = {
            SmallTopAppBar(
                title = { Text(text = "Skripsweet")},
                navigationIcon = {
                    IconButton(onClick = {}) {
                        Icon(Icons.Filled.ArrowBack, "backIcon")
                    }
                },
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = materialBlue100,
                    titleContentColor = Color.White,
                ),
                
            )
        },
        bottomBar = {
            NavigationBar(
                containerColor = materialBlue100
            ) {
                bottomNavItems.forEach{item->
                val selected = item.route == backStack

                }
            }
        },
        content = {
            val checkBoxState = remember {
                mutableStateOf(false)
            }
            CustomCheckBox(title = "Dosen", checkBoxState = checkBoxState.value){
                checkBoxState.value = !checkBoxState.value

            }

        }

    )



}


@Composable
fun CustomCheckBox(
    title: String,
    checkBoxState: Boolean,
    onCheckBoxPressed: ((Boolean)->Unit)?
){
    Row (
        modifier = Modifier.padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ){
        Checkbox(
            checked = checkBoxState,
            onCheckedChange = onCheckBoxPressed,
        )
        Text(text = title)

    }
}

@Composable
fun CustomButton(text: String, color: Color){
    Button(
        onClick = {},
        modifier = Modifier
            .padding(16.dp)
            .clip(RoundedCornerShape(18.dp)),
        colors = ButtonDefaults.buttonColors(containerColor = color)
    )
        {
            Text(text = text, color = Color.Black)
        }
}

