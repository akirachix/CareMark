package com.example.caremark.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.caremark.*
import com.example.caremark.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        castView()
        setupBottomNav()


    }
    fun castView(){
        binding.flFragment
        binding.bottomNavigationView
    }
    fun setupBottomNav(){
        binding.bottomNavigationView.setOnItemSelectedListener { item->
            when(item.itemId){
                R.id.home ->{
                    val  transaction=supportFragmentManager.beginTransaction()
                    transaction.replace(R.id.fragmentContainerView, HomeFragment())
                    transaction.commit()
                    true
                }
                R.id.med ->{
                    val  transaction=supportFragmentManager.beginTransaction()
                    transaction.replace(R.id.fragmentContainerView, MedicationFragment())
                    transaction.commit()
                    true
                }
                R.id.track ->{
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainerView, TrackFragment()).commit()
                    true
                }

                R.id.points ->{
                    val  transaction=supportFragmentManager.beginTransaction()
                    transaction.replace(R.id.fragmentContainerView, PointsFragment())
                    transaction.commit()
                    true
                }
                else -> false

            }
        }

    }
}







