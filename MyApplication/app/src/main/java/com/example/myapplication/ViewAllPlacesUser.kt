package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.adapters.PlacesUserAdapter
import com.example.myapplication.databinding.ActivityViewAllPlacesUserBinding
import com.example.myapplication.dataclasses.Place
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class ViewAllPlacesUser : AppCompatActivity() {
    private lateinit var binding: ActivityViewAllPlacesUserBinding
    private lateinit var databaseRef: DatabaseReference
    private lateinit var recyclerView: RecyclerView
    private var mList = ArrayList<Place>()
    private lateinit var adapter: PlacesUserAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityViewAllPlacesUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        databaseRef = FirebaseDatabase.getInstance().reference.child("Places")

        recyclerView = binding.recyclerView
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this);

        databaseRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                mList.clear()
                for ( snapshot in snapshot.children){
                    val data = snapshot.getValue(Place::class.java)!!
                    if( data != null){
                        mList.add(data)
                    }
                }
                adapter.notifyDataSetChanged()
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@ViewAllPlacesUser, error.message, Toast.LENGTH_SHORT).show()
            }
        })

        adapter = PlacesUserAdapter(mList)
        recyclerView.adapter = adapter

        adapter.setOnItemClickListner(object: PlacesUserAdapter.onItemClickListner {
            override fun onItemClick(position: Int) {
                intent = Intent(applicationContext, ViewAPlace::class.java).also {
                    it.putExtra("name", mList[position].name)
                    it.putExtra("id", mList[position].id)
                    it.putExtra("description", mList[position].description)
                    it.putExtra("location", mList[position].location)
                    startActivity(it)
                }
            }
        })
    }
}