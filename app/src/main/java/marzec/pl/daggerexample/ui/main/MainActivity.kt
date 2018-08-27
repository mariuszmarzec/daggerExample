package marzec.pl.daggerexample.ui.main

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import marzec.pl.daggerexample.App
import marzec.pl.daggerexample.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val appComponent = (application as App).appComponent
        val mainActivityComponent = appComponent.mainActivityComponent()

        singletonButton.setOnClickListener {
            Toast.makeText(this, appComponent.getInt().toString(), Toast.LENGTH_SHORT).show()
        }

        activityScopeButton.setOnClickListener {
            Toast.makeText(this, mainActivityComponent.getInt().toString(), Toast.LENGTH_SHORT).show()
        }
    }
}