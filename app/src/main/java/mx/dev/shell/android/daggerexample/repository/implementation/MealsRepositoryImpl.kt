package mx.dev.shell.android.daggerexample.repository.implementation

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import mx.dev.shell.android.daggerexample.core.model.MealBo
import mx.dev.shell.android.daggerexample.core.repository.MealsRepository
import mx.dev.shell.android.daggerexample.repository.mapper.MealsMapper
import mx.dev.shell.android.daggerexample.repository.service.MealService
import javax.inject.Inject

class MealsRepositoryImpl @Inject constructor(
    private val mealService: MealService,
    private val mapper: MealsMapper
) : MealsRepository {

    override suspend fun getMeals(): Flow<Result<List<MealBo>>> =
        mealService.getMeals()
            .map {
                if (it.isSuccess) {
                    Result.success(mapper(it.getOrNull()!!.categories!!))
                } else {
                    Result.failure(it.exceptionOrNull()!!)
                }
            }
}