package com.example.navigationdrawerwithcutomtoolbar

import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.VIEW_MODEL_STORE_OWNER_KEY
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.example.navigationdrawerwithcutomtoolbar.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var toogle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            toogle = ActionBarDrawerToggle(this@MainActivity, drawerLayout, R.string.open, R.string.close)
            drawerLayout.addDrawerListener(toogle)
            toogle.syncState()

            supportActionBar?.setDisplayHomeAsUpEnabled(true)

            navView.setNavigationItemSelectedListener {
                when(it.itemId) {
                    R.id.first_fragment -> {
                        Log.i("dd", "First Fragment")

                        findNavController(R.id.fragmentContainerView).navigate(R.id.firstFragment)
                    }
                    R.id.second_fragment -> {
                        Log.i("dd", "Second Fragment")
                        findNavController(R.id.fragmentContainerView).navigate(R.id.secondFragment)
                    }
                }
                true
            }
        }

        var flag = true
        binding.topAppBarMainActivity.drawerIcon.apply {
            setOnClickListener {

                Log.i("dd", "clickc ldjlfldjf ldkjjf")
                if (flag) {
                    flag = false
                    binding.drawerLayout.openDrawer(Gravity.LEFT)
                } else {
                    flag = true
                    binding.drawerLayout.openDrawer(Gravity.LEFT)
                }
            }
        }





//        val mFragment =  BlankFragment()
//
//        val trans = supportFragmentManager.beginTransaction()
//        trans.replace(R.id.fragment_container_view, mFragment)
//        trans.commit()

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toogle.onOptionsItemSelected(item))
            true
        return super.onOptionsItemSelected(item)
    }
}