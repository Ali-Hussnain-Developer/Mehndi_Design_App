package com.example.mehndidesignapp.ui.activities

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.mehndidesignapp.R
import com.example.mehndidesignapp.databinding.ActivityMainBinding
import com.example.mehndidesignapp.fragmentUtils.FragmentUtils
import com.example.mehndidesignapp.ui.fragments.HomePageFragment


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val window = this.window
        window.statusBarColor = Color.parseColor(getString(R.color.app_bg_color))
        replaceFragment(HomePageFragment())


    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        FragmentUtils.changeFragment(R.id.Fragment, fragment, fragmentManager)
    }

    override fun onBackPressed() {
        finish()
        super.onBackPressed()
    }
}