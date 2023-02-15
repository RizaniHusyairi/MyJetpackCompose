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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.myjetpackcompose.bottomnav.BottomNav


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BottomNav()
        }
    }
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

