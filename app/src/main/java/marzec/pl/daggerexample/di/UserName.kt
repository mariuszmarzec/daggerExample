package marzec.pl.daggerexample.di

import javax.inject.Inject
import javax.inject.Named

class UserName @Inject constructor(
        @Named("Name") private val name: String,
        @Named("Surname") private val surname: String
) {

    val text
        get() = "$name $surname"
}