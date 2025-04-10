package com.example.buoi2.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.buoi2.Dialog.DialogLogin
import com.example.buoi2.R

@Composable
fun LoginScreen(navController: NavController) {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    val context = LocalContext.current
    var isShowDialog by remember { mutableStateOf(false) }
    var title by remember { mutableStateOf("title") }
    DialogLogin(title,isShowDialog, onDismiss = {isShowDialog = false})


    Column(modifier = Modifier
        .padding(20.dp)
        .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "",
            modifier = Modifier
                .padding(bottom = 20.dp)
                .size(150.dp)
                .align(Alignment.CenterHorizontally)
                .clip(CircleShape)
                .border(1.dp, Color.Red, CircleShape))
        SelectionContainer {
            Text(text = "Login",
                fontSize = 35.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Blue,
                modifier = Modifier
                    .padding(20.dp)
                    .align(Alignment.CenterHorizontally),
            )
        }
        TextField(
            value = "$username",
            onValueChange = {username = it},
            modifier = Modifier
                .padding(start = 10.dp, end = 10.dp)
                .fillMaxWidth(),
            shape = RoundedCornerShape(10.dp)
        )
        TextField(
            value = "$password",
            onValueChange = {password = it},
            modifier = Modifier
                .padding(start = 10.dp, end = 10.dp, top = 10.dp)
                .fillMaxWidth()
                .border(0.dp, color = Color.Blue),
            shape = RoundedCornerShape(10.dp),
        )
        Row(modifier = Modifier
            .padding(start = 10.dp, end = 10.dp, top = 10.dp)
            .align(Alignment.CenterHorizontally)

        ) {
            Button(
                onClick = {
                    if(!username.isBlank() && !password.isBlank()){
                        if(username.equals("admin") && password.equals("admin")){
                            navController.navigate("ListProductScreen");

                        }
                        else{
                            title = "Dang nhap that bai"
                            isShowDialog = true
                        }
                    }
                    else{
                        title = "Vui long nhap thong tin"
                        isShowDialog = true
                    }

                },
                shape = CutCornerShape(12.dp),
                elevation = ButtonDefaults.buttonElevation(
                    defaultElevation = 30.dp,
                    pressedElevation = 30.dp
                )
            ) {
                Image(
                    painter = painterResource(R.drawable.baseline_add_24),
                    contentDescription = "hihih",
                    modifier = Modifier
                        .padding(end = 20.dp)
                        .size(20.dp)
                )
                Text(text = "Hello")
            }
            Button(
                onClick = {

                },
                modifier = Modifier
                    .padding(start = 10.dp),
                colors = androidx.compose.material3.ButtonDefaults.buttonColors(
                    containerColor = Color.Red
                ),
            ) {
                Text(text = "Cancle" )
            }
        }

    }
}