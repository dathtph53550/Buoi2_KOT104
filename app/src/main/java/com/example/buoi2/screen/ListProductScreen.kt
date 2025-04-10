package com.example.buoi2.screen

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.buoi2.Dialog.DialogAdd
import com.example.buoi2.Dialog.DialogDelete
import com.example.buoi2.Dialog.DialogEdit
import com.example.buoi2.R
import com.example.buoi2.models.Product
import com.example.buoi2.service.ViewModelApp

@Composable
fun ListProductScreen(navController: NavController,viewModelApp: ViewModelApp = viewModel()) {
    val context = LocalContext.current
    val listProduct by viewModelApp.listProduct
    var isShowDialogDelete by remember { mutableStateOf(false) }
    var isShowDialogEdit by remember { mutableStateOf(false) }
    var isShowDialogAdd by remember { mutableStateOf(false) }
    var itemSelected by remember { mutableStateOf<Product?>(null) }


    LaunchedEffect(Unit){
        viewModelApp.getListProduct()
    }

    Log.d("ttzzzttt", "ListProductScreen: " + listProduct)

    if(isShowDialogAdd) {
        listProduct?.let {
            DialogAdd(
                isShow = isShowDialogAdd,
                onDismiss = { isShowDialogAdd = false },
                onConfirm = { newProduct ->
                    if (newProduct != null) {
                        viewModelApp.addProduct(newProduct)
                        Toast.makeText(context, "Thêm sản phẩm thành công", Toast.LENGTH_SHORT).show()
                        isShowDialogAdd = false
                    }
                },
                sizeArray = it
            )
        }
    }

    if(isShowDialogEdit && itemSelected != null)
        DialogEdit(isShow = isShowDialogEdit, product = itemSelected,
            onDismiss = { isShowDialogEdit = false },
            onConfirm = { newProduct ->
                viewModelApp.updateProduct(itemSelected!!.id.toString(),newProduct!!)
                Toast.makeText(context, "Sua thanh cong", Toast.LENGTH_SHORT).show()
                isShowDialogEdit = false
        })

    DialogDelete(isShowDialogDelete, onDismiss = {isShowDialogDelete = false}, onConfirm = {
        viewModelApp.deleteProduct(itemSelected!!.id.toString())
        Toast.makeText(context, "Xoa thanh cong", Toast.LENGTH_SHORT).show()
        isShowDialogDelete = false
    })

    Box(modifier = Modifier.fillMaxSize()) {
        LazyColumn(modifier = Modifier.padding(10.dp)) {
            itemsIndexed(listProduct?: emptyList()) { index, item ->
                Row (modifier = Modifier
                    .padding(10.dp)
                    .border(
                        1.dp,
                        color = androidx.compose.ui.graphics.Color.Black,
                        shape = androidx.compose.foundation.shape.RoundedCornerShape(10.dp)
                    )
                    .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically){
                    AsyncImage(model = item.avatar,
                        contentDescription = "",
                        modifier = Modifier
                            .padding(10.dp)
                            .width(100.dp)
                            .height(100.dp),
                        contentScale = ContentScale.FillWidth)
                    Column  {
                        Text(fontWeight = FontWeight.Bold, text = item.name)
                        Text(text = item.price.toString())
                    }
                    Spacer(Modifier.weight(1f))
                    Image(painter = painterResource(id = R.drawable.baseline_edit_24),
                        contentDescription = "",
                        modifier = Modifier
                            .padding(10.dp)
                            .size(30.dp)
                            .clickable {
                                isShowDialogEdit = true
                                itemSelected = item
                            })
                    Image(painter = painterResource(id = R.drawable.baseline_delete_24), contentDescription = "",modifier = Modifier
                        .padding(10.dp)
                        .size(30.dp)
                        .clickable {
                            itemSelected = item
                            isShowDialogDelete = true
                        })
                }
            }
        }
        
        FloatingActionButton(
            onClick = { isShowDialogAdd = true },
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(16.dp)
        ) {
            Text("+")
        }
    }
}


