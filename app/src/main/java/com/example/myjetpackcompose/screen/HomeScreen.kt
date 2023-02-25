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
import com.example.myjetpackcompose.screen.component.CustomTopSkripsi
import com.example.myjetpackcompose.ui.theme.TitleColor
import org.w3c.dom.Text

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen() {
//    Scaffold(
//        topBar ={ CustomTopSkripsi("Skripsi")}
//    ) {
//
//    }
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

