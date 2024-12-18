package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapplication.databinding.ActivityAddEventBinding
import com.example.myapplication.dataclasses.Event
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class AddEvent : AppCompatActivity() {

    private lateinit var binding: ActivityAddEventBinding
    private lateinit var auth: FirebaseAuth
    private lateinit var databaseRef: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddEventBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()
        databaseRef = FirebaseDatabase.getInstance().reference.child("Events")

        binding.btnAdd.setOnClickListener {
            var name = binding.etName.text.toString()
            var location = binding.etLocation.text.toString()
            var description = binding.etDescription.text.toString()

            if(name.isEmpty() || description.isEmpty() || location.isEmpty()){
                if (name.isEmpty()){
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
                val data = Event(name,location,description,id)
                databaseRef.child(id).setValue(data).addOnCompleteListener{
                    if(it.isSuccessful){
                        intent = Intent(applicationContext, ViewAllEventsAdmin::class.java)
                        startActivity(intent)
                        Toast.makeText(this,"Added Successfully", Toast.LENGTH_SHORT).show()
                    }else{
                        Toast.makeText(this, it.exception?.message, Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }

    }
}