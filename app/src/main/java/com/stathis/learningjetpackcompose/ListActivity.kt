package com.stathis.learningjetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.stathis.learningjetpackcompose.abstraction.AbstractActivity
import com.stathis.learningjetpackcompose.ui.theme.LearningJetpackComposeTheme
import kotlinx.coroutines.launch

class ListActivity : AbstractActivity() {

    override fun bindUI() {
        setContent {
            LearningJetpackComposeTheme {
                LazyImageList()
            }
        }
    }
}

/*
 *
 * The Column renders all the list items, even the ones not visible
 * on the screen, which is a performance issue when the list size gets bigger. T
 *
 */

@Composable
fun SimpleList() {
    val scrollState = rememberScrollState()

    Column(Modifier.verticalScroll(scrollState)) {
        repeat(100) {
            Text("Item #1$it")
        }
    }
}

/*
 *
 *  LazyColumn, renders only the visible items on screen, 
 *  allowing performance gains and doesn't need to scroll modifier.
 */

@Composable
fun LazyList() {
    val scrollState = rememberLazyListState()

    LazyColumn(state = scrollState) {
        items(100) {
            Text("I am item no. $it", modifier = Modifier
                .fillMaxWidth()
                .padding(start = 10.dp, end = 10.dp, bottom = 10.dp)
            )
        }
    }
}

/*
 *
 *
 *
 */

@Composable
fun LazyImageList() {

    val listSize = 100
    val scrollState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()

    Column {
        Row {
            Button(onClick = {
                coroutineScope.launch {
                    // 0 is the first item index
                    scrollState.animateScrollToItem(0)
                }
            }) {
                Text("Scroll to the top")
            }

            Button(onClick = {
                coroutineScope.launch {
                    // listSize - 1 is the last index of the list
                    scrollState.animateScrollToItem(listSize - 1)
                }
            }) {
                Text("Scroll to the end")
            }
        }

        LazyColumn(state = scrollState) {
            items(100) {
                ImageListItem(it)
            }
        }
    }
}

@Composable
fun ImageListItem(index: Int) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Image(
            painter = rememberImagePainter(
                data = "https://developer.android.com/images/brand/Android_Robot.png"
            ),
            contentDescription = "Android Logo",
            modifier = Modifier.size(50.dp).padding(start = 16.dp)
        )
        Spacer(Modifier.width(10.dp))
        Text("Item #$index", modifier = Modifier.fillMaxWidth(),style = MaterialTheme.typography.subtitle1)
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview4() {
    LearningJetpackComposeTheme {
        LazyImageList()
    }
}