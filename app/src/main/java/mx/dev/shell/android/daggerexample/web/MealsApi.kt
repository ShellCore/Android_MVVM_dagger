package mx.dev.shell.android.daggerexample.web

import mx.dev.shell.android.daggerexample.web.model.meals.response.MealsResponse
import retrofit2.http.GET

interface MealsApi {

    @GET("categories.php")
    suspend fun getMeals(): MealsResponse
}