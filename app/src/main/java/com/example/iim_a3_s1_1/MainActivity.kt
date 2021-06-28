package com.example.iim_a3_s1_1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.add
import androidx.fragment.app.commit
import com.example.iim_a3_s1_1.databinding.ActivityMainBinding
import com.example.iim_a3_s1_1.fragments.ProductDetailsFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)

        /*supportFragmentManager.beginTransaction()
            //.replace(R.id.list_fragment_container1, ProductsListFragment())
            .replace(R.id.list_fragment_container1, ProductDetailsFragment())
            .commitAllowingStateLoss()*/

        val binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        if (savedInstanceState == null) {
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                add<ProductDetailsFragment>(R.id.list_fragment_container1)
            }
        }

    }
}

