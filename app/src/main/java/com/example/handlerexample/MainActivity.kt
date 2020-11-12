package com.example.handlerexample

import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var handler: Handler
    lateinit var progressBar: ProgressBar
    lateinit var startButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        handler = Handler()
        progressBar = findViewById<View>(R.id.progressBar) as ProgressBar
        startButton = findViewById<View>(R.id.buttonStart) as Button
        startButton.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        when (view.id) {
            R.id.buttonStart -> startProgress()
        }
    }

    private fun startProgress() {
        Thread {
            for (i in 0..30) {
                Thread.sleep(500)
                handler.post{ progressBar.progress = i }
            }
        }.start()
    }
}