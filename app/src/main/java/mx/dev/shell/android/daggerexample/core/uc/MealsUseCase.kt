package mx.dev.shell.android.daggerexample.core.uc

import kotlinx.coroutines.flow.Flow
import mx.dev.shell.android.daggerexample.core.model.MealBo

interface MealsUseCase {
    suspend fun getMeals(): Flow<Result<List<MealBo>>>
}