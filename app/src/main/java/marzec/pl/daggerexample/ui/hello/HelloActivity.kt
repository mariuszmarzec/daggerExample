package marzec.pl.daggerexample.ui.hello

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import marzec.pl.daggerexample.App
import marzec.pl.daggerexample.R

class HelloActivity : AppCompatActivity() {

    lateinit var helloActivityComponent: HelloActivityComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        helloActivityComponent = (application as App).appComponent.helloActivityComponent()
        helloActivityComponent.inject(this)
        setContentView(R.layout.activity_hello)
    }
}
