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
import com.example.myapplication.adapters.EventsUserAdapter
import com.example.myapplication.databinding.ActivityViewAllEventsUserBinding
import com.example.myapplication.dataclasses.Event
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class ViewAllEventsUser : AppCompatActivity() {
    private lateinit var binding: ActivityViewAllEventsUserBinding
    private lateinit var databaseRef: DatabaseReference
    private lateinit var recyclerView: RecyclerView
    private var mList = ArrayList<Event>()
    private lateinit var adapter: EventsUserAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityViewAllEventsUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        databaseRef = FirebaseDatabase.getInstance().reference.child("Events")

        recyclerView = binding.recyclerView
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this);

        databaseRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                mList.clear()
                for ( snapshot in snapshot.children){
                    val data = snapshot.getValue(Event::class.java)!!
                    if( data != null){
                        mList.add(data)
                    }
                }
                adapter.notifyDataSetChanged()
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@ViewAllEventsUser, error.message, Toast.LENGTH_SHORT).show()
            }
        })

        adapter = EventsUserAdapter(mList)
        recyclerView.adapter = adapter


        //Setting onclick on recyclerView each item
        adapter.setOnItemClickListner(object: EventsUserAdapter.onItemClickListner {
            override fun onItemClick(position: Int) {
                intent = Intent(applicationContext, ViewAnEvent::class.java).also {
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