package com.example.myjetpackcompose.font

import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import com.example.myjetpackcompose.R



val customFontPoetsen = FontFamily(
    Font(R.font.poetsen_one_regular),
)
val customFontPoppins = FontFamily(
    Font(R.font.poppins_regular),
    Font(R.font.poppins_bold, FontWeight.Bold),
    Font(R.font.poppins_light, FontWeight.Light),
    Font(R.font.poppins_bolditalic, FontWeight.Bold, FontStyle.Italic),
    Font(R.font.poppins_extrabold, FontWeight.ExtraBold),
    Font(R.font.poppins_medium, FontWeight.Medium),
    Font(R.font.poppins_black, FontWeight.Black),
    Font(R.font.poppins_extralight, FontWeight.ExtraLight),
    Font(R.font.poppins_semibold, FontWeight.SemiBold)
)
