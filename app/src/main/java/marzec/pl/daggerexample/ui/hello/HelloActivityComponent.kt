package marzec.pl.daggerexample.ui.hello

import dagger.Subcomponent
import marzec.pl.daggerexample.di.ActivityScope
import marzec.pl.daggerexample.ui.main.BaseComponent

@ActivityScope
@Subcomponent(modules = [HelloModule::class])
interface HelloActivityComponent : BaseComponent<HelloActivity> {

    @Subcomponent.Builder
    interface Builder : BaseComponent.BaseBuilder<HelloActivity>
}