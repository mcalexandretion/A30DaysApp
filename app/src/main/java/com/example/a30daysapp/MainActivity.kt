package com.example.a30daysapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adviceAdapter: AdviceAdapter
    private var adviceList = mutableListOf<Advice>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        recyclerView = findViewById(R.id.list)


        AdviceRepository.loadAdviceData(this)
        adviceList = AdviceRepository.getAdviceList()


        adviceAdapter = AdviceAdapter(this, adviceList)
        recyclerView.adapter = adviceAdapter
    }
}
