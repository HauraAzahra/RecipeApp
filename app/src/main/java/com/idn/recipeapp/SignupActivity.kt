package com.idn.recipeapp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.idn.recipeapp.databinding.ActivitySignupBinding

class SignupActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var signupBinding : ActivitySignupBinding
    companion object {
        fun getLaunchService(from: Context) = Intent(
            from,
            SignupActivity::class.java
        ).apply {
            addFlags(
                Intent.FLAG_ACTIVITY_NEW_TASK or
                        Intent.FLAG_ACTIVITY_CLEAR_TASK
            )
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        signupBinding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(signupBinding.root)
        supportActionBar?.hide()
        signupBinding.ivBack.setOnClickListener(this)
        signupBinding.tvSignIn.setOnClickListener(this)

    }

    override fun onClick(v: View) {
        when(v.id){
            R.id.iv_back -> startActivity(Intent(SignInActivity.getLaunchService(this)))
            R.id.tv_sign_in -> startActivity(Intent(SignInActivity.getLaunchService(this)))
        }
    }
}