package marzec.pl.daggerexample.ui.main

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_main.*
import marzec.pl.daggerexample.R
import marzec.pl.daggerexample.ui.hello.HelloActivity
import javax.inject.Inject


class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var appName: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        AndroidInjection.inject(this)
        textView.text = appName
        textView.setOnClickListener { startActivity(Intent(this, HelloActivity::class.java)) }

    }

}