package marzec.pl.daggerexample.ui.main

import dagger.Subcomponent
import marzec.pl.daggerexample.di.ActivityScope

@ActivityScope
@Subcomponent(modules = [MainActivityModule::class])
interface MainActivityComponent {
    fun inject(activity: MainActivity)
}