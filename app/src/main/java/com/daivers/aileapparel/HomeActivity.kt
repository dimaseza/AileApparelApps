package com.daivers.aileapparel

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    private lateinit var preferences: Preferences
    private var dataList = ArrayList<Jersey>()

    private var btnsosmed: LinearLayout? = null
    private var btnOrder: LinearLayout? = null
    private var btnFeedback: LinearLayout? = null
    private var btnHowToOrder: LinearLayout? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        btnsosmed = findViewById<View>(R.id.ll_social_media) as LinearLayout
        btnOrder = findViewById<View>(R.id.ll_order_jersey) as LinearLayout
        btnFeedback = findViewById<View>(R.id.ll_feedback) as LinearLayout
        btnHowToOrder = findViewById<View>(R.id.ll_how_to_order) as LinearLayout

        btnsosmed!!.setOnClickListener {
            val sosmedIntent = Intent(this, SocialMediaActivity::class.java)
            startActivity(sosmedIntent)
        }

        btnFeedback!!.setOnClickListener {
            val feedbackIntent = Intent(this, FeedbackActivity::class.java)
            startActivity(feedbackIntent)
        }

        btnOrder!!.setOnClickListener {
            val orderIntent = Intent(this, CheckActivity::class.java)
            startActivity(orderIntent)
        }

        btnHowToOrder!!.setOnClickListener {
            val howToOrderIntent = Intent(this, HowToOrderActivity::class.java)
            startActivity(howToOrderIntent)
        }

        preferences = Preferences(this.applicationContext)

        preferences.getValues("onboarding")

        dataSampleJersey();

        rv_jersey.setHasFixedSize(true)
        rv_jersey.layoutManager = LinearLayoutManager(this)
        val jerseyAdapater = GridJerseyAdapter(dataList) {
            val intent = Intent(this, DetailActivity::class.java).putExtra("data", it)
            startActivity(intent)
        }
        rv_jersey.adapter = jerseyAdapater

        tv_view_all.setOnClickListener {
            val intent = Intent(this, AllJerseyActivity::class.java)
                .putExtra("data", dataList)
            startActivity(intent)
        }


    }

    private fun dataSampleJersey() {
        dataList.add(
            Jersey(1,
                R.drawable.aile_design_1,
                "Jersey Cultural Series",
                "Jersey tanpa celana merupakan produk Cultural Series Aile Apparel",
                "Rp. 110.000,-")
        )
        dataList.add(
            Jersey(2,
                R.drawable.aile_design_2,
                "Jersey Cultural Series",
                "Jersey tanpa celana merupakan produk Cultural Series Aile Apparel",
                "Rp. 110.000,-")
        )
        dataList.add(
            Jersey(3,
                R.drawable.aile_design_3,
                "Jersey Cultural Series",
                "Jersey tanpa celana merupakan produk Cultural Series Aile Apparel",
                "Rp. 110.000,-")
        )
        dataList.add(
            Jersey(4,
                R.drawable.aile_design_4,
                "Jersey Cultural Series",
                "Jersey tanpa celana merupakan produk Cultural Series Aile Apparel",
                "Rp. 110.000,-")
        )
        dataList.add(
            Jersey(5,
                R.drawable.jersey_gold_series_1,
                "Jersey Gold Series",
                "Jersey full printing, sponsor printing dan logo printing merupakan salah satu Reguler Series bertipe Gold dari Aile Apparel.",
                "Rp. 145.000,-")
        )
        dataList.add(
            Jersey(6,
                R.drawable.jersey_gold_series_2,
                "Jersey Gold Series",
                "Jersey full printing, sponsor polyflex dan logo polyflex merupakan salah satu Reguler Series bertipe Gold dari Aile Apparel.",
                "Rp. 175.000,-")
        )
        dataList.add(
            Jersey(7,
                R.drawable.jersey_gold_series_3,
                "Jersey Gold Series",
                "Jersey full printing, sponsor printing dan logo printing merupakan salah satu Reguler Series bertipe Gold dari Aile Apparel.",
                "Rp. 145.000,-")
        )
        dataList.add(
            Jersey(8,
                R.drawable.jersey_silver_series_2,
                "Jersey Silver Series",
                "Jersey printing depan, sponsor polyflex dan logo polyprint merupakan salah satu Reguler Series bertipe Silver dari Aile Apparel.",
                "Rp. 160.000,-")
        )
        dataList.add(
            Jersey(9,
                R.drawable.jersey_silver_series_3,
                "Jersey Silver Series",
                "Jersey printing depan, sponsor printing dan logo printing merupakan salah satu Reguler Series bertipe Silver dari Aile Apparel.",
                "Rp. 130.000,-")
        )
        dataList.add(
            Jersey(10,
                R.drawable.jersey_silver_series_1,
                "Jersey Silver Series",
                "Jersey printing depan, sponsor printing dan logo printing merupakan salah satu Reguler Series bertipe Silver dari Aile Apparel.",
                "Rp. 130.000,-")
        )
    }
}
