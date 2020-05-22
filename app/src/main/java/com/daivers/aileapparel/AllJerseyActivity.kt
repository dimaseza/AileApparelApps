package com.daivers.aileapparel

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_all_jersey.*

class AllJerseyActivity : AppCompatActivity() {

    private var datalist = ArrayList<Jersey>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_all_jersey)

        datalist = intent.getParcelableArrayListExtra("data")
        rv_all_jersey.layoutManager = LinearLayoutManager(this)
        rv_all_jersey.adapter = AllJerseyAdapter(datalist){
            val intent = Intent(this, DetailActivity::class.java)
                .putExtra("data", it)
            startActivity(intent)
        }

    }
}
