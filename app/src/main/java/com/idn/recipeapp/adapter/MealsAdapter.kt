package com.idn.recipeapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.idn.recipeapp.R
import com.idn.recipeapp.model.MealsItemd
import com.idn.recipeapp.model.ResponseDetailMeals
import kotlinx.android.synthetic.main.item_recipe.view.*

class MealsAdapter(var context: Context, var listMeals: List<MealsItemd?>?) :
    RecyclerView.Adapter<MealsAdapter.MealsViewHolder>() {
    inner class MealsViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(listMealsView: ResponseDetailMeals) {
            with(itemView) {
                tv_name_meals.text = listMealsView.meals!![0]?.strMeal
                tv_area_meals.text = listMealsView.meals[0]?.strArea
                Glide.with(context).load(listMealsView.meals[0]?.strImageSource)
                    .into(iv_item_meals)
                itemView.setOnClickListener {  }
            }
        }

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MealsAdapter.MealsViewHolder {
        val view = LayoutInflater.from(context)
            .inflate(R.layout.item_recipe, parent, false)
        return MealsViewHolder(view)
    }

    override fun onBindViewHolder(holder: MealsAdapter.MealsViewHolder, position: Int) {
        holder.bind(listMeals.get(position))
    }

    override fun getItemCount(): Int = listMeals.size
}