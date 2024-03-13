package com.example.medicalreminderapp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun LoginScreen(
    navToHome: () -> Unit
) {
    Box(
        Modifier
            .fillMaxSize()
            .padding(vertical = 56.dp, horizontal = 24.dp)
    )
    {
        HeaderMedicalReminder(Modifier.align(Alignment.TopCenter))
        BodyMedicalReminder(Modifier.align(Alignment.Center), navToHome)
        FooterMedicalReminder(Modifier.align(Alignment.BottomCenter))
    }
}

@Composable
fun FooterMedicalReminder(modifier: Modifier) {
    Column(modifier = modifier.fillMaxWidth()) {
        SignUp()

    }
}

@Composable
fun SignUp() {
    Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
        Text("¿No tiene una cuenta? ", fontSize = 16.sp)
        Text("Registrarse", fontSize = 16.sp, fontWeight = FontWeight.Bold)
    }
}

@Composable
fun BodyMedicalReminder(modifier: Modifier, navToHome: () -> Unit) {
    var email by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    var isLoginEnable by rememberSaveable {
        mutableStateOf(true)
    }

    Column(modifier = modifier) {
        EmailMedicalReminder(email) { email = it }
        Spacer(modifier = Modifier.padding(10.dp))
        PasswordMedicalReminder(password = password) { password = it }
        Spacer(modifier = Modifier.padding(10.dp))
        PrimaryButton(
            isLoginEnable,
            enabledBackgroundColor = colorResource(id = R.color.light_green),
            disabledBackgroundColor = Color.White,
            enabledTextColor = colorResource(id = R.color.white),
            cornerRadius = 0.dp,
            navToHome
        )
        Spacer(modifier = Modifier.padding(10.dp))
        TextGeneral(Modifier.align(Alignment.CenterHorizontally))
    }
}

@Composable
fun TextGeneral(modifier: Modifier) {
    Text(
        text = "¿Olvidó la contraseña?", fontSize = 14.sp,
        color = Color.Black,
        modifier = modifier
    )
}

@Composable
fun PrimaryButton(
    loginEnable: Boolean,
    enabledBackgroundColor: Color = colorResource(id = R.color.light_green),
    disabledBackgroundColor: Color = Color.White,
    enabledTextColor: Color = colorResource(id = R.color.white),
    cornerRadius: Dp = 0.dp,
    navToHome: () -> Unit
    //modifier: Modifier
) {
    Button(
        onClick = navToHome, enabled = loginEnable, modifier = Modifier
            .fillMaxWidth()
            .size(
                width = dimensionResource(id = R.dimen.button_medium_width),
                height = dimensionResource(id = R.dimen.button_medium_height)
            ),
        shape = RoundedCornerShape(cornerRadius),
        colors = ButtonDefaults.buttonColors(
            containerColor = enabledBackgroundColor,
            contentColor = enabledTextColor,
            // disabledBackgroundColor = disabledBackgroundColor,
            //  disabledContentColor = disabledTextColor
            // enabledTextColor = enabledTextColor
        )
    )
    {
        Text("Ingresar", fontSize = 18.sp)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PasswordMedicalReminder(password: String, onTextChanged: (String) -> Unit) {

    var passwordVisibility by remember { mutableStateOf(false) }

    TextField(
        value = password, onValueChange = { onTextChanged(it) }, modifier = Modifier.fillMaxWidth(),
        colors = TextFieldDefaults.textFieldColors(containerColor = colorResource(id = R.color.light_gray)),
        singleLine = true,
        maxLines = 1,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        trailingIcon = {
            val image = if (passwordVisibility) {
                Icons.Filled.KeyboardArrowLeft
            } else {
                Icons.Filled.Lock
            }
            IconButton(onClick = { passwordVisibility = !passwordVisibility }) {
                Icon(imageVector = image, contentDescription = "Icon password")
            }
        },
        visualTransformation = if (passwordVisibility) {
            VisualTransformation.None
        } else {
            PasswordVisualTransformation()
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EmailMedicalReminder(email: String, onTextChanged: (String) -> Unit) {
    TextField(
        value = email, onValueChange = { onTextChanged(it) }, modifier = Modifier.fillMaxWidth(),
        colors = TextFieldDefaults.textFieldColors(containerColor = colorResource(id = R.color.light_gray)),
        singleLine = true,
        maxLines = 1,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
    )
}

@Composable
fun HeaderMedicalReminder(modifier: Modifier) {
    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = CenterHorizontally) {
        Text(
            "Medical Reminder",
            color = Color.Black,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Normal,
            fontSize = 40.sp
        )
        Spacer(modifier = Modifier.padding(10.dp))
        Text(
            "Ingresar",
            color = Color.Black,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Normal,
            fontSize = 36.sp
        )
    }
}