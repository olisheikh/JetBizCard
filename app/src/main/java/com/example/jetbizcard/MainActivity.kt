package com.example.jetbizcard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.jetbizcard.ui.theme.JetBizCardTheme
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.Image
import androidx.compose.material.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.remember
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.foundation.background
import androidx.compose.ui.text.font.FontWeight

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
    val buttonClickedState = remember{
        mutableStateOf(false)
    }

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
            backgroundColor = Color.Gray,
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

                Button(
                    onClick = {
                        buttonClickedState.value = !buttonClickedState.value

                    },
                    modifier = Modifier.padding(10.dp)
                ) {
                    Text(
                        text = "Portfolio",
                        style = MaterialTheme.typography.button
                    )
                }
                if (buttonClickedState.value){
                    Content()
                }else{
                    Box(){

                    }
                }
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun Content(){
    Box(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .padding(5.dp)
    ){
        Surface(
            modifier = Modifier
                .padding(3.dp)
                .fillMaxHeight()
                .fillMaxWidth(),
            border = BorderStroke(
                width = 2.dp,
                color = Color.LightGray
            ),
        ){
            Portfolio(data = listOf("Project 1", "Project 2", "Project 3"))
        }
    }
}

@Composable
fun Portfolio(data: List<String>){
    LazyColumn{
        items(data){item ->
           Card(
               modifier = Modifier
                   .padding(7.dp)
                   .fillMaxWidth(),
               shape = RectangleShape,
               backgroundColor = Color.Blue,
               elevation = 4.dp
           ){
               Row(
                   modifier = Modifier
                       .padding(8.dp)
                       .background(MaterialTheme.colors.surface)
                       .padding(7.dp)
               ){
                    CreateProfileImage(modifier = Modifier
                        .size(100.dp))
                    Column(modifier = Modifier
                        .padding(7.dp)
                        .align(alignment = Alignment.CenterVertically)){

                        Text(text = item, fontWeight = FontWeight.Bold)
                        Text(text = "A great project",
                            style = MaterialTheme.typography.body2)

                    }
               }

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
            contentDescription = "Profile Image",
            modifier = modifier.size(100.dp)
        )
    }
}
//@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetBizCardTheme {
        CreateBizCard()
    }
}