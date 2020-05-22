package com.daivers.aileapparel

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_on_boarding_two.*

class OnBoardingTwoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_on_boarding_two)

        tv_next2.setOnClickListener {
            finish()
            startActivity(Intent(this, OnBoardingThreeActivity::class.java))
            overridePendingTransition(R.anim.slide_in, R.anim.slide_in_out)
        }

        tv_skip2.setOnClickListener {
            finish()
            startActivity(Intent(this, HomeActivity::class.java))
        }
    }
}
