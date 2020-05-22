package com.daivers.aileapparel

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_on_boarding_three.*

class OnBoardingThreeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_on_boarding_three)

        tv_get_started.setOnClickListener {
            finishAffinity()
            startActivity(Intent(this, WelcomeActivity::class.java))
            overridePendingTransition(R.anim.slide_in, R.anim.slide_in_out)
        }
    }
}
