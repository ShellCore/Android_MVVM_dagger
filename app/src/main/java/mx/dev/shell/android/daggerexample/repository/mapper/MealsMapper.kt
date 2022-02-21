package mx.dev.shell.android.daggerexample.repository.mapper

import mx.dev.shell.android.daggerexample.core.model.MealBo
import mx.dev.shell.android.daggerexample.web.model.meals.response.Category
import javax.inject.Inject

class MealsMapper @Inject constructor() : Function1<List<Category>, List<MealBo>> {

    override fun invoke(p1: List<Category>): List<MealBo> = p1.map {
        MealBo(
            id = it.idCategory!!.toInt(),
            name = it.strCategory!!,
            description = it.strCategoryDescription!!,
            imgSrc = it.strCategoryThumb!!
        )
    }
}
