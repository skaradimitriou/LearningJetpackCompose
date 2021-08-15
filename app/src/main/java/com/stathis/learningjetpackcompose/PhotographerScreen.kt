package com.stathis.learningjetpackcompose

import android.util.Log
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.stathis.learningjetpackcompose.abstraction.AbstractActivity
import com.stathis.learningjetpackcompose.ui.theme.LearningJetpackComposeTheme

class PhotographerScreen : AbstractActivity() {

    override fun bindUI() {
        setContent {
            LearningJetpackComposeTheme {
                PhotographerCard()
            }
        }
    }
}

@Composable
fun PhotographerCard(modifier: Modifier = Modifier) {
    Row(modifier
        .clickable(onClick = {
            Log.d("", "")
        })
        .padding(16.dp)) {
        Surface(
            modifier = Modifier.size(50.dp),
            shape = CircleShape,
            color = MaterialTheme.colors.onSurface.copy(alpha = 0.2f)
        ) {
            Image(
                painter = painterResource(id = R.mipmap.ic_launcher),
                contentDescription = "",
                contentScale = ContentScale.Fit,
                modifier = Modifier.fillMaxSize()
            )
        }

        Column(
            Modifier
                .padding(start = 10.dp)
                .align(Alignment.CenterVertically)
        ) {
            Text("Alfred Sisley", fontWeight = FontWeight.Bold)
            // LocalContentAlpha is defining opacity level of its children
            CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
                Text("3 minutes ago", style = MaterialTheme.typography.body2)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview3() {
    LearningJetpackComposeTheme {
        PhotographerCard()
    }
}