package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapplication.databinding.ActivityAddHotelsBinding
import com.example.myapplication.dataclasses.Hotel
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class AddHotels : AppCompatActivity() {

    private lateinit var binding: ActivityAddHotelsBinding
    private lateinit var auth: FirebaseAuth
    private lateinit var databaseRef: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddHotelsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()
        databaseRef = FirebaseDatabase.getInstance().reference.child("Hotels")

        binding.btnAdd.setOnClickListener {
            var name = binding.etName.text.toString()
            var location = binding.etLocation.text.toString()
            var description = binding.etDescription.text.toString()

            if(name.isEmpty() || description.isEmpty() || location.isEmpty()){
                if(name.isEmpty()){
                    binding.etName.error = "Enter Name"
                }
                if(description.isEmpty()){
                    binding.etDescription.error = "Enter Description"
                }
                if(location.isEmpty()){
                    binding.etLocation.error = "Enter Location"
                }
            }else{
                var id = databaseRef.push().key!!
                val data = Hotel(name,location,description,id)
                databaseRef.child(id).setValue(data).addOnCompleteListener{
                    if(it.isSuccessful){
                        intent = Intent(applicationContext, ViewAllHotelsAdmin::class.java)
                        startActivity(intent)
                        Toast.makeText(this, "Added Successfully", Toast.LENGTH_SHORT).show()
                    }else{
                        Toast.makeText(this, it.exception?.message,Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }
}