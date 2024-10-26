package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapplication.databinding.ActivityAdminDashboardBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class AdminDashboard : AppCompatActivity() {

    private lateinit var binding: ActivityAdminDashboardBinding
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAdminDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()
        binding.btnLogout.setOnClickListener {
            Firebase.auth.signOut()
            intent = Intent(applicationContext, SplashActivity::class.java)
            startActivity(intent)
            Toast.makeText(this, "Successfully logged out", Toast.LENGTH_SHORT).show()
        }
        binding.btnHotels.setOnClickListener {
            intent = Intent(applicationContext, ViewAllHotelsAdmin::class.java)
            startActivity(intent)
        }
        binding.btnPlaces.setOnClickListener {
            intent = Intent(applicationContext, ViewAllPlacesAdmin::class.java)
            startActivity(intent)
        }
        binding.btnEvents.setOnClickListener {
            intent = Intent(applicationContext, ViewAllEventsAdmin::class.java)
            startActivity(intent)
        }
    }
}