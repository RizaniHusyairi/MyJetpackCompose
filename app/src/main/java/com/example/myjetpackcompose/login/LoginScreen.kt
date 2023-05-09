package com.example.myjetpackcompose.login

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.myjetpackcompose.R
import com.example.myjetpackcompose.font.customFontPoppins


@Composable
@Preview(showBackground = true)
fun showLoginScreen(){
    val navController = rememberNavController()
    LoginScreen(navController = navController)
}

@Composable
fun LoginScreen(navController: NavController) {
    ConstraintLayout (modifier = Modifier.fillMaxSize()) {
        val (blueLine,redLine,logo,boxLogin) = createRefs()
        Image(
            painter = painterResource(id = R.drawable.vector_biru) ,
            contentDescription = "biru",
            modifier = Modifier
                .constrainAs(blueLine){
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                }
                .size(300.dp)
                .offset(x = (-200).dp)
        )
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.constrainAs(logo){
                top.linkTo(blueLine.bottom, margin = (-220).dp)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo_si),
                contentDescription = "logo",
                modifier = Modifier.size(120.dp),
                alignment = Alignment.Center
            )

            Text(
                text = "SKRIPSWEET",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xff555658),
                fontFamily = customFontPoppins,
                )

            Text(
                text = "SISTEM INFORMASI",
                color = Color(0xff555658),
                fontFamily = customFontPoppins,
                modifier = Modifier.offset(y = (-10).dp)
            )
        }
        Image(
            painter = painterResource(id = R.drawable.vector_merah) ,
            contentDescription = "merah",
            modifier = Modifier
                .size(300.dp)
                .constrainAs(redLine){
                    top.linkTo(logo.bottom, margin = (-130).dp)
                    end.linkTo(parent.end)
                }
                .offset(x = 190.dp)

        )
        Column(
            modifier = Modifier
                .constrainAs(boxLogin){
                    top.linkTo(redLine.bottom)
                    bottom.linkTo(parent.bottom, margin = 270.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                },
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Spacer(modifier = Modifier.padding(10.dp))
            Box(
                modifier = Modifier
                    .offset(y = 30.dp)
//                .shadow(
//                    elevation = 1.dp,
//                    ambientColor = Color(0x3C000000),
//                    shape = RoundedCornerShape(16.dp)
//                )
                    .background(
                        color = Color(0x4DE1E1E1),
                        shape = RoundedCornerShape(16.dp)

                    )
                    .fillMaxWidth(),
                contentAlignment = Alignment.Center

            ) {
                Column(
                    modifier = Modifier.padding(vertical = 50.dp, horizontal = 10.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    val nim = NimTextField()
                    val pass = PassTextField()

                    Spacer(modifier = Modifier.padding(vertical = 20.dp))
                    CustomButton(text = "LOGIN", color = Color(0xff3C6489)) {
                        Log.e("NIM", nim)
                        Log.e("Pass", pass)
                        navController.navigate(MainScreen.MahasiswaScreen.route)

                    }

                }
            }

        }

    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NimTextField(): String {
    val textState = remember { mutableStateOf("") }
    OutlinedTextField(
        value = textState.value,
        onValueChange = {
            textState.value = it
        },
        label = {
            Text(text = "NIM/NIP")
        },
        leadingIcon = {
            Icon(

                imageVector = Icons.Outlined.Person,
                modifier = Modifier.padding(end = 5.dp),
                tint = Color.Black,
                contentDescription = "NIM/NIP"
            )

        },
        singleLine = true
    )
    return textState.value
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PassTextField(): String {
    val textState = remember { mutableStateOf("") }
    OutlinedTextField(
        value = textState.value,
        onValueChange = {
            textState.value = it
        },
        label = {
            Text(text = "Password")
        },
        leadingIcon = {
            Icon(

                imageVector = Icons.Outlined.Lock,
                modifier = Modifier.padding(end = 5.dp),
                tint = Color.Black,
                contentDescription = "Password"
            )

        },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password,
            imeAction = ImeAction.Done
        ),
        visualTransformation = PasswordVisualTransformation(),
        singleLine = true
    )
    return textState.value
}


@Composable
fun CustomButton(text: String, color: Color, eventClick: () -> Unit) {
    Button(
        onClick = eventClick,
        modifier = Modifier.size(width = 280.dp, height = 50.dp),
        colors = ButtonDefaults.buttonColors(containerColor = color),
        shape = RoundedCornerShape(5.dp)
    )
    {
        Text(
            text = text,
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )
    }
}


