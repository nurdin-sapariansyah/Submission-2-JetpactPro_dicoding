package com.nurdin.submission1jetpackpro.view.activity.settings

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import android.view.MenuItem
import android.widget.Button
import androidx.appcompat.app.ActionBar
import com.nurdin.submission1jetpackpro.R

class SettingActivity : AppCompatActivity() {
    private lateinit var button : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setting)

        if (supportActionBar != null) {
            (supportActionBar as ActionBar).title = getString(R.string.setting)
        }
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        button = findViewById(R.id.button_language)
        button.setOnClickListener{
            val mIntent = Intent(Settings.ACTION_LOCALE_SETTINGS)
            startActivity(mIntent)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) finish()
        return super.onOptionsItemSelected(item)
    }
}