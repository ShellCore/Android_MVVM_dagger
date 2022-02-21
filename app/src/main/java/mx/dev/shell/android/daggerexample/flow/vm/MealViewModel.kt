package mx.dev.shell.android.daggerexample.flow.vm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import mx.dev.shell.android.daggerexample.core.model.MealBo
import mx.dev.shell.android.daggerexample.core.uc.MealsUseCase

class MealViewModel constructor(
    private val uc: MealsUseCase
) : ViewModel() {

    val mealList = MutableLiveData<List<MealBo>>()
    val mealDetail = MutableLiveData<MealBo>()
    val errorMessage = MutableLiveData<String>()

    fun loadMeals() {
        viewModelScope.launch(Dispatchers.IO) {
            uc.getMeals().collect {
                if (it.isSuccess) {
                    mealList.postValue(it.getOrNull().orEmpty())
                } else {
                    errorMessage.postValue(it.exceptionOrNull()?.message ?: "Unknown error")
                }
            }
        }
    }
}