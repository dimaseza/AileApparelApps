package com.daivers.aileapparel

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class ForgotPasswordActivity : AppCompatActivity() {

    private val TAG = "ForgotPasswordActivity"

    private var etEmail: EditText? = null
    private var btnSendEmail: Button? = null

    //firebase
    private var mAuth: FirebaseAuth? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password)

        initialise()
    }

    private fun initialise() {
        etEmail = findViewById<View>(R.id.edEmail) as EditText
        btnSendEmail = findViewById<View>(R.id.btn_send_email) as Button

        mAuth = FirebaseAuth.getInstance()
        btnSendEmail!!.setOnClickListener { sendPasswordResetEmail() }
    }

    private fun sendPasswordResetEmail() {
        val email = etEmail?.text.toString()

        if(!TextUtils.isEmpty(email)){
            mAuth!!.sendPasswordResetEmail(email)
                .addOnCompleteListener { task ->
                    if(task.isSuccessful){
                        val message = "Email sent."
                        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
                        updateUI()
                    }else{
                        Toast.makeText(this, "No user found with this email.", Toast.LENGTH_SHORT).show()
                    }
                }
        }else{
            Toast.makeText(this, "Enter Email.", Toast.LENGTH_SHORT).show()
        }

    }

    private fun updateUI() {
        val intent = Intent(this, SignInActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intent)
    }
}
