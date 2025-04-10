package com.example.buoi2.Dialog

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog

@Composable
fun DialogDelete(isShow: Boolean, onDismiss: () -> Unit, onConfirm: () -> Unit) {
    if(isShow){
        Dialog(onDismissRequest = { }){
            Card(modifier = Modifier
                .fillMaxWidth()
                .height(200.dp),
                elevation = CardDefaults.cardElevation(40.dp),
                shape = CutCornerShape(10.dp)
            ) {
                Column(modifier = Modifier
                    .background(Color.Cyan)
                    .fillMaxSize(),
                    verticalArrangement = Arrangement.SpaceAround,
                    horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(text = "Bạn có muốn xoá không ?", fontSize = 32.sp, fontWeight = FontWeight.Bold)
                    Row {
                        Button(onClick = onDismiss, shape = RoundedCornerShape(10.dp)) {
                            Text(text = "Cancle")
                        }
                        Button(onClick = onConfirm, shape = RoundedCornerShape(10.dp)) {
                            Text(text = "OK")
                        }
                    }
                }
            }
        }
    }
}