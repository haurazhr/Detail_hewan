package com.example.recycleview

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var btnListView: Button
    private lateinit var btnRvBuku: Button
    private lateinit var btnRvBuah: Button
    private lateinit var btnRvMovie: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        btnListView = findViewById(R.id.btnListView)
        btnRvBuku = findViewById(R.id.btnRvBuku)
        btnRvBuah = findViewById(R.id.btnRvBuah)
        btnRvMovie = findViewById(R.id.btnRvMovie)

        btnListView.setOnClickListener() {
            var intent = Intent(this@MainActivity, ListView::class.java)
            startActivity(intent)
        }

        btnRvBuku.setOnClickListener() {
            var intent = Intent(this@MainActivity, RecycleViewBuku::class.java)
            startActivity(intent)
        }

        btnRvBuah.setOnClickListener() {
            var intent = Intent(this@MainActivity, RecycleViewBuah::class.java)
            startActivity(intent)
        }

        btnRvMovie.setOnClickListener() {
            var intent = Intent(this@MainActivity, RecycleViewMovie::class.java)
            startActivity(intent)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

}