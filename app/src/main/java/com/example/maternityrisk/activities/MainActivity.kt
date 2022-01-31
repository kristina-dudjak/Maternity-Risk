package com.example.maternityrisk.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.maternityrisk.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.entry).setOnClickListener {
            val intent = Intent(this, EntryActivity::class.java)
            startActivity(intent)
        }
    }
}