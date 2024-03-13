package com.example.medicalreminderapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen() {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = { },
        content = { innerPadding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .padding(horizontal = 12.dp, vertical = 50.dp)
            ) {
                Body()
            }
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { },
                shape = CircleShape,
                containerColor = Color.Black,
                elevation = FloatingActionButtonDefaults.bottomAppBarFabElevation()
            ) {
                Icon(
                    Icons.Filled.Add, "Plus",
                    tint = Color.White,
                    modifier = Modifier.size(60.dp)
                )
            }
        },
        floatingActionButtonPosition = FabPosition.Center,
    )
}

@Composable
fun HeaderIntro() {
    Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            "Mis Recordatorios",
            color = Color.Black,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Normal,
            fontSize = 30.sp
        )
    }
}

@Composable
fun CalendarImage() {
    Image(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        painter = painterResource(id = R.drawable.calendar),
        contentDescription = null
    )
}

@Composable
fun TextDeleteMedicament() {
    Image(
        modifier = Modifier
            .fillMaxWidth(0.8f)
            .height(80.dp)
            .padding(horizontal = 12.dp),
        painter = painterResource(id = R.drawable.note),
        contentDescription = null
    )
}

@Composable
fun TextMedicament() {
    Text(
        "Medicamentos",
        modifier = Modifier.padding(horizontal = 12.dp),
        color = Color.Black,
        fontWeight = FontWeight.Bold,
        fontStyle = FontStyle.Normal,
        fontSize = 17.sp
    )
}

@Composable
fun Body() {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        item {
            HeaderIntro()
        }
        item {
            CalendarImage()
        }
        item {
            TextDeleteMedicament()
        }
        item {
            TextMedicament()
        }
        item {
            ColumItem(
                "Aspirina",
                "10:00 AM"
            )
        }
        item {
            ColumItem(
                "Ibuprofeno",
                "1:00 PM"
            )
        }
    }
}

@Composable
fun ColumItem(
    title: String,
    hour: String
) {
    var isChecked by remember {
        mutableStateOf(false)
    }
    Box(
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(80.dp)
                .background(Color(0x4DDCDCDC)),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Checkbox(
                modifier = Modifier.weight(0.2f),
                checked = isChecked,
                onCheckedChange = { isChecked = !isChecked }
            )
            Column(
                modifier = Modifier
                    .weight(0.6f)
                    .padding(top = 16.dp, start = 32.dp),
            ) {
                Text(
                    text = title,
                    style = TextStyle(fontSize = 17.sp, fontWeight = FontWeight.W700)
                )
                Text(
                    text = hour,
                    style = TextStyle(fontSize = 14.sp, fontWeight = FontWeight.W400),
                    modifier = Modifier.padding(top = 6.dp)
                )
            }
            Icon(
                modifier = Modifier.weight(0.2f),
                painter = painterResource(id = R.drawable.baseline_edit),
                contentDescription = ""
            )
        }
    }
}