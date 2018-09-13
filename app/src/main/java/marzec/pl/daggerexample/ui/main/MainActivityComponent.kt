package marzec.pl.daggerexample.ui.main

import dagger.Subcomponent
import marzec.pl.daggerexample.di.ActivityScope

@ActivityScope
@Subcomponent(modules = [MainActivityModule::class])
interface MainActivityComponent : BaseComponent<MainActivity> {

    @Subcomponent.Builder
    interface Builder : BaseComponent.BaseBuilder<MainActivity>
}
