package com.example.push_notification

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import kotlin.toString as toString1

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        supportActionBar?.hide()
        var name=this.findViewById<TextView>(R.id.name)
        val prof=this.findViewById<TextView>(R.id.profession)

    name.setText(intent.getStringExtra("name"))
      prof.setText(intent.getStringExtra("profession"))



    }

}