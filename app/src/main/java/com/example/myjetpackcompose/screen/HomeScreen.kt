package com.example.myjetpackcompose.screen

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowRight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.myjetpackcompose.R
import com.example.myjetpackcompose.feature_skripsweet.data.data_source.BimbinganMahasiswaTemp
import com.example.myjetpackcompose.font.customFontPoppins
import com.example.myjetpackcompose.screen.component.CustomListBimbinganHome
import com.example.myjetpackcompose.screen.component.TapLayoutDospem
import com.example.myjetpackcompose.ui.theme.ColorIconBar

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun HomeScreen(navController: NavHostController, dataBimbingan:List<BimbinganMahasiswaTemp>) {
    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .padding(start = 10.dp, end = 10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
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
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 5.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Text(
                text = "Bimbingan skripsi",
                fontFamily = customFontPoppins,
                fontSize = 17.sp
            )
                Icon(imageVector = Icons.Filled.ArrowRight, contentDescription = "Bimbingan Skripsi Lengkap",
                    modifier = Modifier.clickable { navController.navigate("Bimbingan") })
        }



        LazyRow(
            modifier = Modifier.padding(vertical = 5.dp),
            horizontalArrangement = Arrangement.spacedBy(7.dp),
            content = {
            items(items = dataBimbingan){bimbingan ->
                CustomListBimbinganHome(bimbingan = bimbingan)
            }
        })
    }

}

