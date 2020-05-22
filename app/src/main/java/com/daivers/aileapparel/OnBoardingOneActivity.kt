package com.daivers.aileapparel

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.android.synthetic.main.activity_on_boarding_one.*

class OnBoardingOneActivity : AppCompatActivity() {

    private var mAuth: FirebaseAuth? = null
    private var user: FirebaseUser? = null

    private lateinit var preferences: Preferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_on_boarding_one)

        mAuth = FirebaseAuth.getInstance()

        user = mAuth!!.currentUser
        if(user != null){
            updateUI()
        }

        preferences = Preferences(this)
        if(preferences.getValues("onboarding").equals("1")){
            finishAffinity()

            val intent = Intent(this, SignInActivity::class.java)
            startActivity(intent)
        }

        tv_next1.setOnClickListener {
            finish()
            startActivity(Intent(this, OnBoardingTwoActivity::class.java))
            overridePendingTransition(R.anim.slide_in, R.anim.slide_in_out)
        }

        tv_skip1.setOnClickListener {
            finishAffinity()
            startActivity(Intent(this, WelcomeActivity::class.java))
            overridePendingTransition(R.anim.slide_in, R.anim.slide_in_out)
        }
    }

    private fun updateUI() {
        finish()
        val intent = Intent(this, HomeActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intent)
    }
}
