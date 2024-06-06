package com.example.xpensemanager.Components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CButton(
    onClick: () -> Unit = {},
    text: String,
    containerColor: Color = LocalContentColor.current // Default to the current content color
) {
    // reusable button
    Button(
        onClick = onClick,
        shape = MaterialTheme.shapes.large,
        colors = ButtonDefaults.buttonColors(containerColor),
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
            .height(52.dp)
    ) {
        Text(
            text = text,
            style = TextStyle(
                fontSize = 22.sp,
                fontWeight = FontWeight(500),
                color = Color.White
            )
        )
    }
}