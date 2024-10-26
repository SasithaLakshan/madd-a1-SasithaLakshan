package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapplication.databinding.ActivityBookTourBinding
import com.example.myapplication.dataclasses.Tour
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class BookTour : AppCompatActivity() {

    private lateinit var binding: ActivityBookTourBinding
    private lateinit var auth: FirebaseAuth
    private lateinit var databaseRef: DatabaseReference
    private lateinit var uid: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBookTourBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()
        uid = auth.currentUser?.uid.toString()
        databaseRef = FirebaseDatabase.getInstance().reference.child("Bookings").child(uid)

        binding.btnCalcTot.setOnClickListener {
            var destination = binding.etDestination.text.toString()
            var adultsCount = binding.etAdults.text.toString()
            var childrenCount = binding.etChildren.text.toString()
            var vehicleType = binding.etChildren.text.toString()
            var daysCount = binding.etNoDays.text.toString()

            if(destination.isEmpty() || adultsCount.isEmpty() || vehicleType.isEmpty() || daysCount.isEmpty()){
                if(destination.isEmpty()){
                    binding.etDestination.error = "Enter destination"
                }
                if(adultsCount.isEmpty()){
                    binding.etAdults.error = "Enter adults count"
                }
                if(vehicleType.isEmpty()){
                    binding.etVehicleType.error = "Enter vehicle type"
                }
                if(daysCount.isEmpty()){
                    binding.etNoDays.error = "Enter number of days"
                }
            } else {

                var adCount = adultsCount.toInt()
                var chCount = childrenCount.toInt()
                var nDays = daysCount.toInt()

                var totFee = (((adCount * 10) + (chCount * 5)) * nDays)
                var tot = totFee.toString()
                binding.tvTotal.text = tot

                binding.btnSubmit.setOnClickListener { //Id for new record
                    var id = databaseRef.push().key!!
                    val data = Tour( destination, adultsCount, childrenCount,vehicleType,daysCount,tot,id,uid)
                    databaseRef.child(id).setValue(data).addOnCompleteListener {
                        if (it.isSuccessful){
                            intent = Intent(applicationContext, PayNow::class.java).also {
                                it.putExtra("bookingId", id)
                                it.putExtra("totFee", tot)
                                startActivity(it)
                            }
                            //Toast.makeText(this, "Booking added successfully", Toast.LENGTH_SHORT).show()
                        } else {
                            Toast.makeText(this, it.exception?.message, Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            }
        }
    }
}