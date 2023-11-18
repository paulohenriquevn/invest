package com.github.paulohenriquevn.invest

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.github.paulohenriquevn.invest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        with(binding) {
            replaceFragment(HomeFragment())
            bottomNavigation.setOnItemSelectedListener {
                when (it.itemId) {
                    R.id.menu_assessoria -> replaceFragment(AssessoriaFragment())
                    R.id.menu_noticia -> replaceFragment(NoticiaFragment())
                    R.id.menu_home -> replaceFragment(HomeFragment())
                    R.id.menu_bolsa -> replaceFragment(BolsaFragment())
                    R.id.menu_vitrine -> replaceFragment(VitrineFragment())
                }
                true
            }
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout, fragment)
        fragmentTransaction.commit()
    }

}