package mx.dev.shell.android.daggerexample.core.uc

import mx.dev.shell.android.daggerexample.core.repository.MealsRepository
import javax.inject.Inject

class MealsUseCaseImpl @Inject constructor(
    private val repository: MealsRepository
) : MealsUseCase {

    override suspend fun getMeals() = repository.getMeals()
}