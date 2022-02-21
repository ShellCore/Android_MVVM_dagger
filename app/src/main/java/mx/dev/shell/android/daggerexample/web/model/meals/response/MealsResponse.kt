package mx.dev.shell.android.daggerexample.web.model.meals.response

import com.google.gson.annotations.SerializedName

data class MealsResponse(
    @SerializedName("categories")
    var categories: List<Category>? = null
)