package marzec.pl.daggerexample.ui.main

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import marzec.pl.daggerexample.App
import marzec.pl.daggerexample.R
import marzec.pl.daggerexample.di.DependencyInjection
import marzec.pl.daggerexample.ui.hello.HelloActivity
import javax.inject.Inject
import javax.inject.Provider
import kotlin.reflect.KClass


class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var appName: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        DependencyInjection.inject(this)
        textView.text = appName
        textView.setOnClickListener { startActivity(Intent(this, HelloActivity::class.java)) }

    }

}