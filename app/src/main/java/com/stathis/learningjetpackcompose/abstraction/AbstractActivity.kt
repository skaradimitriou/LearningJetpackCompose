package com.stathis.learningjetpackcompose.abstraction

import android.os.Bundle
import androidx.activity.ComponentActivity

abstract class AbstractActivity : ComponentActivity() {

    abstract fun bindUI()
    abstract fun init()
    abstract fun startOps()
    abstract fun stopOps()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindUI()
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        init()
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onPostResume() {
        super.onPostResume()
        startOps()
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onStop() {
        stopOps()
        super.onStop()
    }

    override fun onRestart() {
        super.onRestart()
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}