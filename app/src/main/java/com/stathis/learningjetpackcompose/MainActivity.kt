package com.stathis.learningjetpackcompose

import android.content.Intent
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.stathis.learningjetpackcompose.abstraction.AbstractActivity
import com.stathis.learningjetpackcompose.ui.theme.LearningJetpackComposeTheme

class MainActivity : AbstractActivity() {

    override fun bindUI() {
        setContent {
            Column(
                modifier = Modifier
                    .background(Color.Green)
                    .fillMaxHeight(0.5f)
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                ButtonExample()
            }
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
    Column(
        modifier = Modifier
            .background(Color.Green)
            .fillMaxHeight(0.5f)
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text("Hello")
        Text("World")
    }
}