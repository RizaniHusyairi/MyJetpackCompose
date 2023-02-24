package com.example.myjetpackcompose.screen

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myjetpackcompose.font.customFontPoetsen
import com.example.myjetpackcompose.font.customFontPoppins
import org.w3c.dom.Text

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen() {
    Scaffold(
        topBar ={ CustomTopSkripsi()}
    ) {

    }
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Text(
            text = "kdasdkfs",
            fontSize = 20.sp,
            modifier = Modifier.padding(top = 90.dp)
        )

    }

}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTopSkripsi(){
    Box(modifier = Modifier
        .height(80.dp)
        .fillMaxWidth()
    ){
        TopAppBar(
            modifier = Modifier.padding(top = 24.dp),
            title = {
                Text(
                    text = "Skripsi",
                fontFamily = customFontPoetsen
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
        Toast.makeText(context,"Notification",Toast.LENGTH_SHORT).show()
    }) {
        Icon(
            imageVector = Icons.Outlined.Notifications,
            contentDescription = "Notification",
            tint = Color.Black
        )

    }
}