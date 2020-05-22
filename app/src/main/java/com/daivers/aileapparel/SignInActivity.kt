package com.daivers.aileapparel

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.*
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.android.synthetic.main.activity_sign_in.*

class SignInActivity : AppCompatActivity() {

    private val TAG = "LoginActivity"

    //global variables
    private var email: String? = null
    private var password: String? = null

    private var tvForgotPassword: TextView? = null
    private var etEmail: EditText? = null
    private var etPassword: EditText?= null
    private var btnLogin: Button? = null
    private var createAccount: TextView? = null
    private var mProgressBar: ProgressDialog? = null

    lateinit var preferences: Preferences

    //firebase
    private var mAuth: FirebaseAuth? = null
    private var user: FirebaseUser? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)



//        preferences = Preferences(this)
//
//        preferences.setValues("onboarding","1")
//
//        if(preferences.getValues("status").equals("1")){
//            finishAffinity()
//
//            val intent = Intent(this, HomeActivity::class.java)
//            startActivity(intent)
//        }

        initialise()
    }

    private fun initialise() {
        tvForgotPassword = findViewById<View>(R.id.tvForgot) as TextView
        etEmail = findViewById<View>(R.id.edtEmail) as EditText
        etPassword = findViewById<View>(R.id.edtPassword) as EditText
        btnLogin = findViewById<View>(R.id.btn_login_home) as Button
        createAccount = findViewById<View>(R.id.daftar_disini) as TextView
        mProgressBar = ProgressDialog(this)

        mAuth = FirebaseAuth.getInstance()

        user = mAuth!!.currentUser
        if(user != null){
            updateUI()
        }

        tvForgotPassword!!.setOnClickListener { startActivity(Intent(this, ForgotPasswordActivity::class.java)) }

        createAccount!!.setOnClickListener { startActivity(Intent(this, RegisterActivity::class.java)) }

        btnLogin!!.setOnClickListener { loginUser() }

    }

    private fun loginUser() {
        email = etEmail?.text.toString()
        password = etPassword?.text.toString()

        if(!TextUtils.isEmpty(email) && !TextUtils.isEmpty(password)){
            mProgressBar!!.setMessage("Logging User...")
            mProgressBar!!.show()

            mAuth!!.signInWithEmailAndPassword(email!!, password!!)
                .addOnCompleteListener(this) { task ->
                    mProgressBar!!.hide()

                    if(task.isSuccessful){
                        updateUI()
                    }else{
                        Toast.makeText(this, "Email or Password wrong!", Toast.LENGTH_SHORT).show()
                    }
                }

        }else {
            Toast.makeText(this, "Enter all details", Toast.LENGTH_SHORT).show()
        }

    }

    private fun updateUI() {
        finish()
        val intent = Intent(this, HomeActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intent)
    }
}
