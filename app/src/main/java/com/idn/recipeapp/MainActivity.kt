package com.idn.recipeapp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.google.firebase.auth.FirebaseAuth
import com.idn.recipeapp.adapter.MealsAdapter
import com.idn.recipeapp.databinding.ActivityMainBinding
import com.idn.recipeapp.model.ResponseDetailMeals
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var mainBinding: ActivityMainBinding

    companion object {
        fun getLaunchService(from: Context) = Intent(
            from,
            MainActivity::class.java
        ).apply {
            addFlags(
                Intent.FLAG_ACTIVITY_NEW_TASK
                        or Intent.FLAG_ACTIVITY_CLEAR_TASK
            )
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)
        mainBinding.btnLogout.setOnClickListener(this)
        supportActionBar?.hide()

        getRecipeAsean()

    }

    private fun getRecipeAsean() {
        //konek ke retrofit konfig .. membuat request
        //sukses sama gagal

        //sukses
        //data di get terus ditempel ke rv
        val listMeals = ResponseDetailMeals().meals
            //... response.
        val recipeAdapter = MealsAdapter(this@MainActivity, listMeals)
        rv_popular_recipes.adapter =recipeAdapter
        rv_popular_recipes.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)

        //gagal kasih toast
    }

    fun signOut() {
        startActivity(Intent(SignInActivity.getLaunchService(this)))
        FirebaseAuth.getInstance().signOut()
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.btn_logout -> signOut()
        }
    }
}