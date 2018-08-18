package marzec.pl.daggerexample.di

import javax.inject.Inject

class UserName @Inject constructor(
        @Name private val name: String,
        @Surname private val surname: String
) {

    val text
        get() = "$name $surname"
}