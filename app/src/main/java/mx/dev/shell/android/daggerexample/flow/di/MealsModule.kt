package mx.dev.shell.android.daggerexample.flow.di

import dagger.Module
import dagger.Provides
import mx.dev.shell.android.daggerexample.core.repository.MealsRepository
import mx.dev.shell.android.daggerexample.core.uc.MealsUseCase
import mx.dev.shell.android.daggerexample.core.uc.MealsUseCaseImpl
import mx.dev.shell.android.daggerexample.repository.implementation.MealsRepositoryImpl
import mx.dev.shell.android.daggerexample.repository.mapper.MealsMapper
import mx.dev.shell.android.daggerexample.repository.service.MealService
import mx.dev.shell.android.daggerexample.repository.service.MealServiceImpl
import mx.dev.shell.android.daggerexample.web.MealClient
import mx.dev.shell.android.daggerexample.web.MealsApi

@Module
class MealsModule {

    @Provides
    fun providesMealsUseCase(repository: MealsRepository): MealsUseCase =
        MealsUseCaseImpl(repository)

    @Provides
    fun providesMealsRepository(
        mealService: MealService,
        mapper: MealsMapper
    ): MealsRepository =
        MealsRepositoryImpl(mealService, mapper)

    @Provides
    fun providesMealService(api: MealsApi): MealService = MealServiceImpl(api)

    @Provides
    fun providesMealsMapper() = MealsMapper()

    @Provides
    fun providesMealsApi(): MealsApi = MealClient.getClient().create(MealsApi::class.java)
}