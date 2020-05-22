package com.daivers.aileapparel

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class SplashScreenActivity : AppCompatActivity() {
    private val SPLASH_TIME:Long=1000 // 1 second

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        Handler().postDelayed({
            finish()
            startActivity(Intent(this, OnBoardingOneActivity::class.java))
            overridePendingTransition(R.anim.slide_in, R.anim.slide_in_out)
        }, SPLASH_TIME)
    }
}
