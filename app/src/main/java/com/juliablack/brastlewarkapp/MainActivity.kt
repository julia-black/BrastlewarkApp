package com.juliablack.brastlewarkapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.juliablack.brastlewarkapp.ui.main.ListFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, ListFragment.newInstance())
                .commitNow()
        }
    }
}