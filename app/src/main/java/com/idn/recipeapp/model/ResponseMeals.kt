package com.idn.recipeapp.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ResponseMeals(

	@field:SerializedName("meals")
	val meals: List<MealsItem?>? = null
) : Parcelable

@Parcelize
data class MealsItem(

	@field:SerializedName("strMealThumb")
	val strMealThumb: String? = null,

	@field:SerializedName("idMeal")
	val idMeal: String? = null,

	@field:SerializedName("strMeal")
	val strMeal: String? = null
) : Parcelable
