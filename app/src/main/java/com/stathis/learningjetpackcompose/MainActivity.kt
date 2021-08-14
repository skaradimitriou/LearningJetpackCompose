package com.stathis.learningjetpackcompose

import android.content.Intent
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.stathis.learningjetpackcompose.abstraction.AbstractActivity

class MainActivity : AbstractActivity() {

    override fun bindUI() {
        setContent {
            val appName = "Tselementes"
            val desc = "Lorem Ipsum sit dolor amet"
            SplashScreen(appName, desc)
        }
    }

    override fun init() {}

    override fun startOps() {}

    override fun stopOps() {}
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Composable
fun SplashScreen(appName: String, appDesc: String) {
    ConstraintLayout(modifier = Modifier
        .fillMaxSize()
        .fillMaxWidth()
        .background(Color.White)) {

        val (image, text) = createRefs()
        Image(
                painter = painterResource(id = R.mipmap.ic_launcher),
                contentDescription = appName,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .height(100.dp)
                    .width(100.dp)
                    .paddingFromBaseline(0.dp,20.dp)
                    .constrainAs(image) {
                        top.linkTo(parent.top)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        bottom.linkTo(parent.bottom)
                    }
        )
        Text(appDesc,Modifier.constrainAs(text){
            top.linkTo(image.bottom)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        })
    }
}

@Composable
fun ButtonExample() {
    val context = LocalContext.current
    val intent = Intent(context, ImageCardActivity::class.java)

    Button(onClick = {
        context.startActivity(intent)
    }) {
        Text("Button")
    }
}

@Composable
fun WhichScreen(screenName: String) {
    Text("You are on $screenName screen")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SplashScreen("My App", "Hello from my app")
}