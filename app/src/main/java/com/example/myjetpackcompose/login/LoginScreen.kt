package com.example.myjetpackcompose.login

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController


@Composable
fun LoginScreen(navController: NavController) {
 Column(
     modifier = Modifier.fillMaxWidth(),
     horizontalAlignment = Alignment.CenterHorizontally
 ) {
     Button(
         onClick = {
                   navController.navigate(MainScreen.MahasiswaScreen.route)
         },
         modifier = Modifier
             .padding(16.dp)
             .clip(RoundedCornerShape(18.dp)),
         colors = ButtonDefaults.buttonColors(containerColor = Color.Yellow)
     )
     {
         Text(text = "Login", color = Color.Black)
     }

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