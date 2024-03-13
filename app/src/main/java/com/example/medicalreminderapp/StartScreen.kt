package com.example.medicalreminderapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StartScreen(
    navToLogin: () -> Unit
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = { },
        content = { innerPadding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .padding(start = 8.dp, end = 8.dp, top = 40.dp, bottom = 110.dp),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                HeaderIntroStartScreen()
                ImageDoctors()
                StartButton(loginEnable = true, navToLogin = navToLogin)
            }
        }
    )
}

@Composable
fun HeaderIntroStartScreen() {
    Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            "Medical Reminder",
            color = Color.Black,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Normal,
            fontSize = 40.sp
        )
    }
}

@Composable
fun ImageDoctors() {
    Image(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.8f),
        painter = painterResource(id = R.drawable.intro1),
        contentDescription = null
    )
}

@Composable
fun StartButton(
    loginEnable: Boolean,
    enabledBackgroundColor: Color = colorResource(id = R.color.light_green),
    enabledTextColor: Color = colorResource(id = R.color.white),
    cornerRadius: Dp = 10.dp,
    navToLogin: () -> Unit
) {
    Button(
        onClick = navToLogin, enabled = loginEnable, modifier = Modifier
            .fillMaxWidth()
            .height(54.dp)
            .padding(start = 10.dp, end = 10.dp),
        shape = RoundedCornerShape(cornerRadius),
        colors = ButtonDefaults.buttonColors(
            containerColor = enabledBackgroundColor,
            contentColor = enabledTextColor,
        )
    )
    {
        Text("Empezar", fontSize = 18.sp)
    }
}