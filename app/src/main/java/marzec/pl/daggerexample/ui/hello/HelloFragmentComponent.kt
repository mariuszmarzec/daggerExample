package marzec.pl.daggerexample.ui.hello

import dagger.Subcomponent
import marzec.pl.daggerexample.di.FragmentScope
import marzec.pl.daggerexample.ui.main.BaseComponent

@Subcomponent
@FragmentScope
interface HelloFragmentComponent : BaseComponent<HelloFragment> {

    @Subcomponent.Builder
    interface Builder : BaseComponent.BaseBuilder<HelloFragment>
}