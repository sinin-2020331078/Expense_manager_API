package com.example.xpensemanager.Components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.xpensemanager.ui.theme.DeepIndigo
import com.example.xpensemanager.ui.theme.Teal

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CTextField(
    modifier : Modifier = Modifier,
    onValueChange : (String) -> Unit ={
    },
    hint : String,
    leadingIcon: ImageVector? = null

) {
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        var text by remember { mutableStateOf("") }
        OutlinedTextField(
            value = text,
            modifier = Modifier
                .background(Color.White) // Set white background
                .padding(start=16.dp, bottom = 4.dp, end = 16.dp),
            onValueChange = {newText ->
                text = newText
            },
            label = {
                Text(text = hint)
            },
            leadingIcon = {
                leadingIcon?.let { icon ->
                    IconButton(onClick = {}) {
                        Icon(
                            imageVector = icon,
                            contentDescription = null
                        )
                    }
                }
            }

        )
    }
}
