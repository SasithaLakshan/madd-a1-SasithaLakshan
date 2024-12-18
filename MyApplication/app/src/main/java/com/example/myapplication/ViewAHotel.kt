package com.example.myapplication

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapplication.databinding.ActivityViewAhotelBinding

class ViewAHotel : AppCompatActivity() {
    private lateinit var binding: ActivityViewAhotelBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityViewAhotelBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvHotelName.text = intent.getStringExtra("name").toString()
        binding.tvCity.text = intent.getStringExtra("location").toString()
        binding.tvDes.text = intent.getStringExtra("description").toString()
    }
}