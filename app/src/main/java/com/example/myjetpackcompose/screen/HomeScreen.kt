package com.example.myjetpackcompose.screen

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowRight
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ModifierInfo
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myjetpackcompose.R
import com.example.myjetpackcompose.font.customFontPoetsen
import com.example.myjetpackcompose.font.customFontPoppins
import com.example.myjetpackcompose.screen.component.CustomTopSkripsi
import com.example.myjetpackcompose.screen.component.TapLayoutDospem
import com.example.myjetpackcompose.ui.theme.ColorAbu
import com.example.myjetpackcompose.ui.theme.ColorIconBar
import com.example.myjetpackcompose.ui.theme.TitleColor
import org.w3c.dom.Text

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen() {
    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .padding(10.dp),
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
            fontWeight = FontWeight.SemiBold,
            fontFamily = customFontPoppins,
            fontSize = 20.sp
            )
        Text(
            text = "1915036123",
            fontFamily = customFontPoppins,
            fontSize = 15.sp
            )
        Box(
            modifier = Modifier.padding(top=10.dp)
        ) {
            Column(
                horizontalAlignment = Alignment.End
            ) {
                Text(
                    text = "Rancang Bangun Aplikasi Skripsi Berbasis Android di Program Studi Sistem Informasi Fakultas Teknik Universitas Mulawarman",
                    textAlign = TextAlign.Center,
                    fontFamily = customFontPoppins,
                    fontSize = 17.sp,
                )
                Icon(
                    painter = painterResource(id = R.drawable.edit_judul_skripsi),
                    contentDescription = "Edit judul skripsi",
                    modifier = Modifier.size(26.dp),
                    tint = ColorIconBar
                )
            }
        }
        TapLayoutDospem()
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Text(
                text = "Bimbingan skripsi",
                fontFamily = customFontPoppins,
                fontSize = 14.sp
            )
            Icon(imageVector = Icons.Filled.ArrowRight, contentDescription = "Bimbingan Skripsi Lengkap")
        }
    }

}

