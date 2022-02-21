package mx.dev.shell.android.daggerexample.core.repository

import kotlinx.coroutines.flow.Flow
import mx.dev.shell.android.daggerexample.core.model.MealBo

interface MealsRepository {
    suspend fun getMeals(): Flow<Result<List<MealBo>>>
}