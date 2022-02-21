package mx.dev.shell.android.daggerexample.repository.service

import kotlinx.coroutines.flow.Flow
import mx.dev.shell.android.daggerexample.web.model.meals.response.MealsResponse

interface MealService {
    suspend fun getMeals(): Flow<Result<MealsResponse>>
}
