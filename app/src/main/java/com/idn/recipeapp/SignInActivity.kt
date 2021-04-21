package com.idn.recipeapp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.idn.recipeapp.databinding.ActivitySignInBinding

class SignInActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var signinBinding: ActivitySignInBinding

    companion object {
        fun getLaunchService(from: Context) = Intent(
            from,
            SignInActivity::class.java
        ).apply {
            addFlags(
                Intent.FLAG_ACTIVITY_NEW_TASK or
                        Intent.FLAG_ACTIVITY_CLEAR_TASK
            )
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        signinBinding = ActivitySignInBinding.inflate(layoutInflater)
        setContentView(signinBinding.root)
        supportActionBar?.hide()
        firebaseAuth = FirebaseAuth.getInstance()
        signinBinding.tvForgot.setOnClickListener(this)
        signinBinding.btnSignIn.setOnClickListener(this)
        signinBinding.tvSignUp.setOnClickListener(this)
    }

    private fun signIn() {
        val email = signinBinding.etEmailSignIn.text.toString()
        val password = signinBinding.etPssSignIn.text.toString()
        if (email.isEmpty() || password.isEmpty()) {
            Toast.makeText(this,
                "Tidak  boleh Kosong",
                Toast.LENGTH_SHORT).show()
        }

        FirebaseAuth.getInstance()
            .signInWithEmailAndPassword(email, password)
            .addOnCompleteListener {
                if (it.isSuccessful){
                    Toast.makeText(this, "Login Success",
                        Toast.LENGTH_SHORT).show()
                    startActivity(MainActivity.getLaunchService(this))
                    return@addOnCompleteListener
                }

        }


    }

    override fun onClick(v: View) {
    }
}