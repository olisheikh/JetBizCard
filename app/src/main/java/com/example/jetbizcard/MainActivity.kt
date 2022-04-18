package com.example.jetbizcard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.jetbizcard.ui.theme.JetBizCardTheme
import androidx.compose.material.Card
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.Image
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.painterResource
import androidx.compose.material.Divider
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetBizCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    CreateBizCard()
                }
            }
        }
    }
}

@Composable
fun CreateBizCard(){
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ){
        Card(
            modifier = Modifier
                .width(300.dp)
                .height(400.dp)
                .padding(10.dp),
            backgroundColor = Color.Green,
            elevation = 10.dp,
            shape = RoundedCornerShape(20.dp),

        ){
            Column(
                modifier = Modifier
                    .height(300.dp)
                    .padding(top = 5.dp),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally,
            ){
                CreateProfileImage()

                Divider(
                    thickness = 10.dp,
                    color = Color.Red
                )

                CreateInfo()
            }
        }
    }
}

@Composable
fun CreateInfo(){
    Column(){
        Text(
            text = "Miles P.",
            style = MaterialTheme.typography.h3,
            color = MaterialTheme.colors.primaryVariant
        )
        Text(
            text = "Jetpack Compose programmer",
            modifier = Modifier.padding(3.dp)
        )
        Text(
            text = "@jetpack.com",
            modifier = Modifier.padding(2.dp),
            style = MaterialTheme.typography.subtitle1
        )
    }
}

@Composable
fun CreateProfileImage(
    modifier: Modifier = Modifier
){
    Surface(
        modifier = Modifier
            .size(150.dp)
            .padding(5.dp),
        color = MaterialTheme.colors.onSurface.copy(alpha = 0.4f),
        elevation = 4.dp,
        shape = CircleShape,

        ){
        Image(
            painter = painterResource(id = R.drawable.profile_img),
            contentDescription = "Profile Image"
        )
    }
}
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetBizCardTheme {
        CreateBizCard()
    }
}