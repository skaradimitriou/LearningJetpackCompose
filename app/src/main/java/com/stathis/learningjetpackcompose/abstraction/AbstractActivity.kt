package com.stathis.learningjetpackcompose.abstraction

import android.os.Bundle
import androidx.activity.ComponentActivity

abstract class AbstractActivity : ComponentActivity() {

    abstract fun bindUI()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindUI()
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onPostResume() {
        super.onPostResume()
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onStop() {
        super.onStop()
    }

    override fun onRestart() {
        super.onRestart()
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}