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
import com.example.myapplication.adapters.HotelsAdminAdapter
import com.example.myapplication.databinding.ActivityViewAllHotelsAdminBinding
import com.example.myapplication.dataclasses.Hotel
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class ViewAllHotelsAdmin : AppCompatActivity() {
    private lateinit var binding: ActivityViewAllHotelsAdminBinding
    private lateinit var databaseRef: DatabaseReference
    private lateinit var recyclerView: RecyclerView
    private var mList = ArrayList<Hotel>()
    private lateinit var adapter: HotelsAdminAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityViewAllHotelsAdminBinding.inflate(layoutInflater)
        setContentView(binding.root)

        databaseRef = FirebaseDatabase.getInstance().reference.child("Hotels")

        recyclerView = binding.recyclerView
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this);

        databaseRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                mList.clear()
                for ( snapshot in snapshot.children){
                    val data = snapshot.getValue(Hotel::class.java)!!
                    if( data != null){
                        mList.add(data)
                    }
                }
                adapter.notifyDataSetChanged()
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@ViewAllHotelsAdmin, error.message, Toast.LENGTH_SHORT).show()
            }
        })

        adapter = HotelsAdminAdapter(mList)
        recyclerView.adapter = adapter


        //Setting onclick on recyclerView each item
        adapter.setOnItemClickListner(object: HotelsAdminAdapter.onItemClickListner {
            override fun onItemClick(position: Int) {
                intent = Intent(applicationContext, UpdateHotel::class.java).also {
                    it.putExtra("name", mList[position].name)
                    it.putExtra("id", mList[position].id)
                    it.putExtra("description", mList[position].description)
                    it.putExtra("location", mList[position].location)
                    startActivity(it)
                }
            }

        })

        binding.btnAdd.setOnClickListener {
            intent = Intent(applicationContext, AddHotels::class.java)
            startActivity(intent)
        }

    }
}