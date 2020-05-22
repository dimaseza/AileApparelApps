package com.daivers.aileapparel

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    //private var datalist = ArrayList<Jersey>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val data = intent.getParcelableExtra<Jersey>("data")

        jersey_design.setImageURI(Uri.parse("android.resource://"+packageName+"/"+data.image))
        title_jersey.text = data.title
        price_jersey.text = data.harga
        tv_description.text = data.desc

    }
}
