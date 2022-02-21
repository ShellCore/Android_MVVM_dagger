package mx.dev.shell.android.daggerexample.flow.di

import dagger.Component
import mx.dev.shell.android.daggerexample.flow.layout.DetailFragment
import mx.dev.shell.android.daggerexample.flow.layout.ListFragment

@Component(
    modules = [
        MealsModule::class
    ]
)
interface MealsComponent {

    fun inject(fragment: ListFragment)
    fun inject(fragment: DetailFragment)
}