package com.daivers.aileapparel

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class CheckActivity : AppCompatActivity() {

    private var btnOrder: Button? = null
    private var btnPrice: Button? = null
    private var btnFontSize: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_check)

        btnOrder = findViewById<View>(R.id.btn_order) as Button
        btnPrice = findViewById<View>(R.id.btn_check_price) as Button
        btnFontSize = findViewById<View>(R.id.btn_check_font_size) as Button

        btnOrder!!.setOnClickListener {
            goOrder()
        }

        btnPrice!!.setOnClickListener {
            goPrice()
        }

        btnFontSize!!.setOnClickListener {
            goFont()
        }

    }

    private fun goFont() {
        val intent = Intent(this, SizeAndFontActivity::class.java)
        startActivity(intent)
    }

    private fun goOrder(){
        val url = "https://wa.me/6285645014653?text=Saya%20ingin%20order%20jersey"
            //"https://api.whatsapp.com/send?phone=6285645014653"
        val sendIntent = Intent()
        sendIntent.action = Intent.ACTION_VIEW
        sendIntent.setPackage("com.whatsapp")
        sendIntent.setData(Uri.parse(url))
        startActivity(sendIntent)
    }

    private fun goPrice(){
        val intent = Intent(this, PriceActivity::class.java)
        startActivity(intent)
    }

}
