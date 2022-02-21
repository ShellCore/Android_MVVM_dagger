package mx.dev.shell.android.daggerexample.flow.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import mx.dev.shell.android.daggerexample.core.uc.MealsUseCase
import javax.inject.Inject

class MealViewModelFactory @Inject constructor(
    private val uc: MealsUseCase
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MealViewModel(uc) as T
    }
}