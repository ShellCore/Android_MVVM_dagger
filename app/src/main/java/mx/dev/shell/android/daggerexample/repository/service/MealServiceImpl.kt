package mx.dev.shell.android.daggerexample.repository.service

import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import mx.dev.shell.android.daggerexample.web.MealsApi
import javax.inject.Inject

class MealServiceImpl @Inject constructor(
    private val api: MealsApi
) : MealService {

    override suspend fun getMeals() = flow {
        emit(Result.success(api.getMeals()))
    }.catch {
        emit(Result.failure(RuntimeException("Something went wrong")))
    }
}