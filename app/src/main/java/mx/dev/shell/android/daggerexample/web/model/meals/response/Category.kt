package mx.dev.shell.android.daggerexample.web.model.meals.response

import com.google.gson.annotations.SerializedName

data class Category(
    @SerializedName("idCategory")
    var idCategory: String? = null,
    @SerializedName("strCategory")
    var strCategory: String? = null,
    @SerializedName("strCategoryDescription")
    var strCategoryDescription: String? = null,
    @SerializedName("strCategoryThumb")
    var strCategoryThumb: String? = null
)