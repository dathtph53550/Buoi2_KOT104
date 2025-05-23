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
fun DialogAdd(isShow: Boolean, onDismiss: () -> Unit, onConfirm: (productNew: Product?) -> Unit,sizeArray: List<Product>) {
    var newName by remember { mutableStateOf("") }
    var newPrice by remember { mutableStateOf("") }
    var newAvatar by remember { mutableStateOf("") }

    if(isShow){
        Dialog(onDismissRequest = { onDismiss() }){
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
                    Text(text = "Thêm sản phẩm mới", fontSize = 32.sp, fontWeight = FontWeight.Bold)
                    TextField(
                        value = newName,
                        onValueChange = { newName = it },
                        label = { Text("Tên sản phẩm") }
                    )
                    TextField(
                        value = newPrice,
                        onValueChange = { newPrice = it },
                        label = { Text("Giá") }
                    )
                    TextField(
                        value = newAvatar,
                        onValueChange = { newAvatar = it },
                        label = { Text("URL ảnh") }
                    )
                    Row {
                        Button(onClick = onDismiss, shape = RoundedCornerShape(10.dp)) {
                            Text(text = "Hủy")
                        }
                        Button(
                            onClick = {
                                if (newName.isNotEmpty() && newPrice.isNotEmpty() && newAvatar.isNotEmpty()) {
                                    onConfirm(Product(null, newName, newPrice.toDouble(), newAvatar))
                                }
                            },
                            shape = RoundedCornerShape(10.dp)
                        ) {
                            Text(text = "Thêm")
                        }
                    }
                }
            }
        }
    }
} 