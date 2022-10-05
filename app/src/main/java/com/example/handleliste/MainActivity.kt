package com.example.handleliste

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var tjenesteList: ArrayList<Tjeneste>
    private lateinit var tjenesteAdapter: TjenesteAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)

        tjenesteList = ArrayList()

        tjenesteList.add(Tjeneste(R.drawable.pchjelp , "Virus"))
        tjenesteList.add(Tjeneste(R.drawable.diskc , "DiskC"))
        tjenesteList.add(Tjeneste(R.drawable.lagring , "Lagring"))
        tjenesteList.add(Tjeneste(R.drawable.oppstart , "Oppstart"))
        tjenesteList.add(Tjeneste(R.drawable.diskd , "DiskD"))
        tjenesteList.add(Tjeneste(R.drawable.rens , "Rens"))

        tjenesteAdapter = TjenesteAdapter(tjenesteList)
        recyclerView.adapter = tjenesteAdapter

        tjenesteAdapter.onItemClick = {
            val intent = Intent(this, DetaljertActivity::class.java)
            intent.putExtra("Tjeneste" , it)
            startActivity(intent)
        }
    }
}