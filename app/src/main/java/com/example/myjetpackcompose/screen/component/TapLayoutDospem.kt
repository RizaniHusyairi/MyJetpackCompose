package com.example.myjetpackcompose.screen.component

import androidx.compose.animation.Animatable
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Tab
import androidx.compose.material.TabRowDefaults
import androidx.compose.material.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myjetpackcompose.ui.theme.ColorAbu
import com.example.myjetpackcompose.ui.theme.ColorIconBar
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.pagerTabIndicatorOffset
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch


@OptIn(ExperimentalPagerApi::class)
@Composable
fun TapLayoutDospem(){
    val tabItems  = listOf("Dosen Pembimbing","Dosen Penguji")
    val pagerState = rememberPagerState()
    val coroutineScope = rememberCoroutineScope()
    Surface() {
        Column() {

            TabRow(
                selectedTabIndex = pagerState.currentPage,
                backgroundColor = ColorAbu,
                modifier = Modifier
                    .padding(20.dp)
                    .background(Color.Transparent)
                    .clip(RoundedCornerShape(30.dp)),
                indicator = { tabPositions ->
                    TabRowDefaults.Indicator(
                        Modifier
                            .pagerTabIndicatorOffset(pagerState, tabPositions)
                            .width(0.dp)
                            .height(0.dp)
                    )
                }
            ) {
                tabItems.forEachIndexed{index,title ->
                    val color = remember {
                        Animatable(Color.Black)
                    }
                    
                    LaunchedEffect(key1 = pagerState.currentPage == index){
                        color.animateTo(if (pagerState.currentPage == index) ColorIconBar else ColorAbu)
                    }
                    Tab(
                        text = {
                            Text(title, style = if (pagerState.currentPage == index)
                                TextStyle(color = Color.White, fontSize = 18.sp, textAlign = TextAlign.Center)
                            else TextStyle(color = Color.Black, fontSize = 16.sp, textAlign = TextAlign.Center)

                            )
                        },
                        selected = pagerState.currentPage == index,
                        modifier = Modifier.background(
                            color =  color.value,
                            shape = RoundedCornerShape(30.dp)
                        ),
                        onClick = {
                            coroutineScope.launch {
                                pagerState.animateScrollToPage(index)
                            }
                        })
                }
            }
            HorizontalPager(
                count = tabItems.size,
                state = pagerState,

            ) { page ->
//                Text(
//                    text = tabItems[page],
//                    modifier = Modifier.padding(50.dp),
//                    color = Color.Black
//                )
                when (tabItems[page]){
                    "Dosen Pembimbing" -> {
                        TabDospem()
                    }
                    "Dosen Penguji" -> {
                        Text(text = "Ini tempat penguji")
                    }
                    
                }
                
            }            
        }
    }
}