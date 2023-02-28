package com.example.myjetpackcompose.screen

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myjetpackcompose.R
import com.example.myjetpackcompose.font.customFontPoetsen
import com.example.myjetpackcompose.font.customFontPoppins
import com.example.myjetpackcompose.screen.component.CustomTopSkripsi
import com.example.myjetpackcompose.ui.theme.TitleColor
import org.w3c.dom.Text

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Spacer(modifier = Modifier.padding(top = 100.dp))
        Image(
            painter = painterResource(id = R.drawable.contohpp1),
            contentDescription ="contoh poto",
            modifier = Modifier
                .size(150.dp)
                .clip(CircleShape),
            )

        Text(
            text = "Rizani Husyairi",
            )
        Text(
            text = "1915036123"
            )
        Text(
            text = "Rancang Bangun Aplikasi Skripsi Berbasis Android di Program Studi " +
                    "Sistem Informasi Fakultas Teknik Universitas Mulawarman"
        )

    }

}

