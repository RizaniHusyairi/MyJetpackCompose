package com.example.myjetpackcompose.screen.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myjetpackcompose.R
import com.example.myjetpackcompose.font.customFontPoppins

@Composable
fun TabDospem(){
    RowsItemDospem(fotoDospem = R.drawable.bapak_putut, nama = "Putut Famili Widagdo S.Kom, M.Kom", nip = "193784632489")
    RowsItemDospem(fotoDospem = R.drawable.bapak_putut, nama = "Putut Famili Widagdo S.Kom, M.Kom", nip = "193784632489")
}


@Composable
fun RowsItemDospem(
    fotoDospem: Int,
    nama:String,
    nip:String
){
    Row() {
        Image(
            painter = painterResource(id = fotoDospem),
            contentDescription = nama,
            modifier = Modifier
                .padding(end = 10.dp)
                .size(50.dp)
                .clip(CircleShape)
        )
        Column() {
            Text(
                text = nama,
                fontFamily = customFontPoppins,
                fontSize = 14.sp
            )
            Text(
                text = nip,
                fontFamily = customFontPoppins,
                fontSize = 12.sp
            )

        }

    }

}