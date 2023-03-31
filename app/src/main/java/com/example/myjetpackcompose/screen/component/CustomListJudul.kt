package com.example.myjetpackcompose.screen.component

import android.content.Context
import android.widget.Toast
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.example.myjetpackcompose.MainActivity
import com.example.myjetpackcompose.feature_skripsweet.data.data_source.JudulSkripsi
import com.example.myjetpackcompose.font.customFontPoppins
import com.example.myjetpackcompose.ui.theme.*
import kotlinx.coroutines.launch

@Composable
fun CustomListJudul(judul: JudulSkripsi) {

    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()

    val colorBox = when(judul.status){
        "Pembimbingan" -> ColorPembimbingan
        "Penjadwalan" -> ColorPenjadwalan
        "Seminar" -> ColorSeminar
        "Lulus" -> ColorLulus
        else -> Color.Transparent
    }

    val colorButton = when(judul.status){
        "Pembimbingan" -> ColorButtonPembimbingan
        "Penjadwalan" -> ColorButtonPenjadwalan
        "Seminar" -> ColorButtonSeminar
        "Lulus" -> ColorButtonLulus
        else -> Color.Transparent
    }

    Column() {
        var isVisible by remember {
            mutableStateOf(false)
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    color = colorBox,
                    shape = RoundedCornerShape(topStart = 5.dp, topEnd = 5.dp)

                )
                .padding(8.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Text(
                text = judul.status,
                fontFamily = customFontPoppins,
                fontWeight = FontWeight.SemiBold,
                fontSize = 10.sp,
                color = Color.White

            )
            Text(
                text = judul.posisiSripsi,
                fontFamily = customFontPoppins,
                fontSize = 10.sp,
                color = Color.White

            )
        }
        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    color = colorBox
                )
                .shadow(
                    elevation = 6.dp
                ),
            thickness = 0.dp,
            color = Color.Transparent
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    color = colorBox,
                    shape = RoundedCornerShape(bottomStart = 2.dp, bottomEnd = 2.dp)
                )
                .padding(6.dp),
        horizontalAlignment = Alignment.CenterHorizontally
        ){

            Text(
                text = "Judul Skripsi",
                fontFamily = customFontPoppins,
                fontWeight = FontWeight.Medium,
                fontSize = 10.sp,
                textDecoration = TextDecoration.Underline,
                textAlign = TextAlign.Center,
                color = Color.White
            )
            Text(
                text = judul.judul,
                textAlign = TextAlign.Center,
                fontFamily = customFontPoppins,
                color = Color.White,
                fontSize = 10.sp
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 3.dp),
                horizontalArrangement = Arrangement.End
            ) {
                Button(
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Transparent,

                    ),
                    contentPadding = PaddingValues(),
                    onClick = {
                        isVisible = !isVisible

                    },
                    modifier = Modifier.padding(0.dp)
                ){
                    Box(
                        modifier = Modifier
                            .background(
                                color = colorButton,
                                shape = RoundedCornerShape(8.dp)
                            )
                            .border(
                                width = 1.dp,
                                shape = RoundedCornerShape(8.dp),
                                color = colorBox
                            )
                            .padding(5.dp)
    //                        .clickable(onClick = {
    //                            isVisible = !isVisible
    //                        })
                    ) {
                        Text(
                            text = "Lihat Dosen Penilai",
                            fontFamily = customFontPoppins,
                            fontSize = 10.sp,
                            color = Color.White
                        )

                    }
                }

            }
        }
        AnimatedVisibility(
            visible = isVisible,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Column(
                modifier = Modifier

                    .offset(y = (-2).dp)
                    .background(
                        color = Color(0xffE3E3E3),
                        shape = RoundedCornerShape(bottomEnd = 6.dp, bottomStart = 6.dp)
                    )
                    .border(
                        width = 1.dp,
                        color = colorBox,
                        shape = RoundedCornerShape(bottomEnd = 6.dp, bottomStart = 6.dp)
                    )
                    .padding(8.dp)
            ) {
                Row(modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = judul.dospem1,
                        fontFamily = customFontPoppins,
                        fontSize = 9.sp,

                    )
                    Box(modifier = Modifier
                        .background(
                            color = ColorPembimbing,
                            shape = RoundedCornerShape(10.dp)
                        )
                        .padding(6.dp)
                    ) {
                        Text(
                            text = "Pembimbing 1",
                            fontFamily = customFontPoppins,
                            fontSize = 9.sp,
                            color = Color.White
                        )
                        
                    }
                    
                }
                Row() {
                    Text(text = judul.dospem1)

                }
                
            }
        }

    }
}

@Composable
fun showToast(message: String) {
    val context = LocalContext.current
    Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
}

@Composable
fun BoxDosenPenilai(){

}