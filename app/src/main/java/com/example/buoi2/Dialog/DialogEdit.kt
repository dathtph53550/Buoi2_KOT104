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
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.example.buoi2.models.Product

@Composable
fun DialogEdit(isShow: Boolean,product: Product?, onDismiss: () -> Unit, onConfirm: (productNew: Product?) -> Unit, ) {
    var newName by remember { mutableStateOf(product?.name) }
    var newPrice by remember { mutableStateOf(product?.price) }
    if(isShow){
        Dialog(onDismissRequest = { }){
            Card(modifier = Modifier
                .fillMaxWidth()
                .height(500.dp),
                elevation = CardDefaults.cardElevation(40.dp),
                shape = CutCornerShape(10.dp)
            ) {
                Column(modifier = Modifier
                    .background(Color.Cyan)
                    .fillMaxSize(),
                    verticalArrangement = Arrangement.SpaceAround,
                    horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(text = "Bạn có muốn sua không ?", fontSize = 32.sp, fontWeight = FontWeight.Bold)
                    TextField(value = newName.toString(), onValueChange ={newName = it} )
                    TextField(value = newPrice.toString(), onValueChange ={newPrice = it.toDouble()} )
                    Row {
                        Button(onClick = onDismiss, shape = RoundedCornerShape(10.dp)) {
                            Text(text = "Cancle")
                        }
                        Button(onClick = {
                            onConfirm(Product(product!!.id,newName!!,newPrice!!,product!!.avatar))},
                            shape = RoundedCornerShape(10.dp)) {
                            Text(text = "OK")
                        }
                    }
                }
            }
        }
    }
}