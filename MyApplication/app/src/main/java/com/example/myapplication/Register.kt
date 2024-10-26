package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityRegisterBinding
import com.example.myapplication.dataclasses.User
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase

class Register : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding
    private lateinit var auth: FirebaseAuth
    private lateinit var database: FirebaseDatabase
    private val emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()
        database = FirebaseDatabase.getInstance()

        binding.btnSignUp.setOnClickListener {
            val name = binding.etName.text.toString()
            val email = binding.etEmail.text.toString()
            val pwd = binding.etPwd.text.toString()
            val confirmPwd = binding.etPwdConfirm.text.toString() // New confirm password field

            // Check if fields are empty
            if (name.isEmpty() || email.isEmpty() || pwd.isEmpty() || confirmPwd.isEmpty()) {
                if (name.isEmpty()) binding.etName.error = "Enter your name"
                if (email.isEmpty()) binding.etEmail.error = "Enter your email"
                if (pwd.isEmpty()) binding.etPwd.error = "Enter password"
                if (confirmPwd.isEmpty()) binding.etPwdConfirm.error = "Confirm your password"
            } else if (!email.matches(emailPattern.toRegex())) {
                binding.etEmail.error = "Enter a valid email address"
            } else if (pwd.length < 7) {
                binding.etPwd.error = "Password must be at least 7 characters."
            } else if (pwd != confirmPwd) {
                binding.etPwdConfirm.error = "Passwords mismatch " // New confirm password check
            } else if (!binding.checkBox.isChecked) {
                Toast.makeText(this, "Please accept terms and conditions.", Toast.LENGTH_SHORT).show()
            } else {
                // Create user with FirebaseAuth
                auth.createUserWithEmailAndPassword(email, pwd).addOnCompleteListener {
                    if (it.isSuccessful) {
                        val databaseRef = database.reference.child("users").child(auth.currentUser!!.uid)
                        val user = User(name, email, auth.currentUser!!.uid, "user")
                        databaseRef.setValue(user).addOnCompleteListener { task ->
                            if (task.isSuccessful) {
                                val intent = Intent(this, Login::class.java)
                                startActivity(intent)
                            } else {
                                Toast.makeText(this, "Something went wrong, try again", Toast.LENGTH_SHORT).show()
                            }
                        }
                    } else {
                        Toast.makeText(this, "Something went wrong, try again", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }
}
