package com.example.jettip

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jettip.ui.theme.JetTipTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp{
                TopHeader()
            }
        }
    }
}

@Composable
fun MyApp(content: @Composable ()-> Unit){
    JetTipTheme {
        Surface(color = MaterialTheme.colors.background) {
            content()
        }
    }
}

//@Preview
@Composable
fun TopHeader(totalPerPerson: Double = 134.0){
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(150.dp)
            // same // .clip(shape = RoundedCornerShape(corner = CornerSize(12.dp)))
            .clip(shape = CircleShape.copy(all = CornerSize(12.dp))) // same
        ,
        color = Color(0xFFE9D7F7)
    ) {
        Column(
            modifier = Modifier.padding(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // val total = "%.2f".format(Locale.US, totalPerPerson) // Locale.US 43.34
            val total = "%.2f".format(totalPerPerson) //Locale.Default 43,34
            Text(
                text = "Total per Person",
                style = MaterialTheme.typography.h5
            )
            Text(
                text = "$$total",
                style = MaterialTheme.typography.h4,
                fontWeight = FontWeight.ExtraBold
            )
        }
    }
}

@Preview
@Composable
fun MainContent(){
    Surface(
        modifier = Modifier
            .padding(2.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(corner = CornerSize(8.dp)),
        border = BorderStroke(width = 1.dp, color = Color.LightGray)
    ) {
        Column() {
            Text(text = "Hello again...")
            Text(text = "Hello again...")
            Text(text = "Hello again...")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetTipTheme {
        MyApp{
            Text(text = "Hello Again!")
        }
    }
}
