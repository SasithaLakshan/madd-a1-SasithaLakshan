package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapplication.databinding.ActivityHomeBinding

class Home : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnProfile.setOnClickListener{
            intent = Intent(applicationContext, UserProfile::class.java)
            startActivity(intent)
        }
        binding.btnHotels.setOnClickListener {
            intent = Intent(applicationContext, ViewAllHotelsUser::class.java)
            startActivity(intent)
        }
        binding.btnPlaces.setOnClickListener {
            intent = Intent(applicationContext, ViewAllPlacesUser::class.java)
            startActivity(intent)
        }
        binding.btnEvents.setOnClickListener {
            intent = Intent(applicationContext, ViewAllEventsUser::class.java)
            startActivity(intent)
        }
        binding.btnBookTour.setOnClickListener {
            intent = Intent(applicationContext, BookTour::class.java)
            startActivity(intent)
        }
    }
}