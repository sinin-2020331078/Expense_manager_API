package com.example.xpensemanager.Screens


import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.xpensemanager.XMViewModel
import com.example.xpensemanager.submit
import com.example.xpensemanager.subscriptionOff
import com.example.xpensemanager.subscriptionOn
import com.example.xpensemanager.verify
import com.example.xpensemanager.verifyStatus;
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
//import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.xpensemanager.DestinationScreen
import com.example.xpensemanager.navigateTo
import com.example.xpensemanager.submit
import com.example.xpensemanager.subscriptionOff
import com.example.xpensemanager.subscriptionOn
import com.example.xpensemanager.ui.theme.AbarTryTheme
import com.example.xpensemanager.verify
import com.example.xpensemanager.verifyStatus

/*
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContent {
            AbarTryTheme {
                HomeScreen();
            }
        }
    }
}*/

@Composable
fun StatsIncomeScreen(navController: NavController, vm: XMViewModel) {
    var value by rememberSaveable {
        mutableStateOf("");
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        OutlinedTextField(
            value = value,
            onValueChange = {value = it},
            colors = OutlinedTextFieldDefaults.colors(Color.Black),
            leadingIcon = {
                Icon(
                    imageVector = Icons.Filled.Phone,
                    contentDescription = "Phone number"
                )
            },
            label = { Text("Enter OTP") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
            modifier = Modifier
                .fillMaxWidth(9/11f)
                .padding(10.dp)

        )
        Row(modifier = Modifier
            .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(onClick = {
                submit()
            }, modifier = Modifier.width(130.dp)
            ) {
                Text(text = "Request")
            }

            Button(onClick = {
                verify(value)
            },modifier = Modifier.width(130.dp)) {
                Text(text = "Verify")
            }
        }

        Row(modifier = Modifier
            .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(onClick = {
                subscriptionOn()
            }, modifier = Modifier.width(130.dp)
            ) {
                Text(text = "Subscribe")
            }

            Button(onClick = {
                subscriptionOff()
            },modifier = Modifier.width(130.dp)) {
                Text(text = "Unsubscribe")
            }
        }

        Row(modifier = Modifier
            .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(onClick = {
                verifyStatus()
            }, modifier = Modifier.width(130.dp)
            ) {
                Text(text = "Status")
            }
        }
        Text(text = "Expense",
            color = Color(0XFFFC0000),
            modifier = Modifier
                .padding(6.dp)
                .clickable {
                    navigateTo(navController, DestinationScreen.StatsExpense.route)
                }
        )
    }
}

/*

@Composable
fun HomeScreen() {
    var value by rememberSaveable {
        mutableStateOf("");
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        OutlinedTextField(
            value = value,
            onValueChange = {value = it},
            colors = OutlinedTextFieldDefaults.colors(Color.Black),
            leadingIcon = {
                Icon(
                    imageVector = Icons.Filled.Phone,
                    contentDescription = "Phone number"
                )
            },
            label = { Text("Enter OTP") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
            modifier = Modifier
                .fillMaxWidth(9/11f)
                .padding(10.dp)

        )
        Row(modifier = Modifier
            .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(onClick = {
                submit()
            }, modifier = Modifier.width(130.dp)
            ) {
                Text(text = "Request")
            }

            Button(onClick = {
                verify(value)
            },modifier = Modifier.width(130.dp)) {
                Text(text = "Verify")
            }
        }

        Row(modifier = Modifier
            .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(onClick = {
                subscriptionOn()
            }, modifier = Modifier.width(130.dp)
            ) {
                Text(text = "Subscribe")
            }

            Button(onClick = {
                subscriptionOff()
            },modifier = Modifier.width(130.dp)) {
                Text(text = "Unsubscribe")
            }
        }

        Row(modifier = Modifier
            .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(onClick = {
                verifyStatus()
            }, modifier = Modifier.width(130.dp)
            ) {
                Text(text = "Status")
            }
        }
    }
}


*/
/*
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AbarTryTheme {
        HomeScreen()
    }
}*/
/*
Column(
modifier = Modifier.padding(8.dp),
horizontalAlignment = Alignment.CenterHorizontally
) {
    Text(text = "Expense",
        color = Color(0XFFFC0000),
        modifier = Modifier
            .padding(6.dp)
            .clickable {
                navigateTo(navController, DestinationScreen.StatsExpense.route)
            }
    )
    Text(
        text = "$totalExpense",
        color = Color(0XFF004EFC),
        modifier = Modifier.alpha(0.8f),
        fontSize = 13.sp
    )
}*/
