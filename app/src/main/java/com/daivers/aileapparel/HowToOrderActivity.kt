package com.daivers.aileapparel

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_how_to_order.*

class HowToOrderActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_how_to_order)

        btn_order_now.setOnClickListener {
            val intent = Intent(this, CheckActivity::class.java)
            startActivity(intent)
            finish()
        }

    }
}
