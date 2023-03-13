package com.example.push_notification

import android.os.Bundle
import android.provider.Settings.Secure
import android.util.Log
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()


        val android_id = Secure.getString(
            this.contentResolver,
            Secure.ANDROID_ID
        )
            println("Hello Dear$android_id")
        Log.d("Android", "AndHeello meer$android_id")
    }
}


