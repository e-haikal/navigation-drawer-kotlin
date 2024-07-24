package com.siaptekno.navigation_drawer_kotlin

import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var drawerLayout: DrawerLayout
    private lateinit var toolbar: Toolbar
    private lateinit var navigationView: NavigationView
    private lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inisialisasi Toolbar
        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        // Inisialisasi DrawerLayout dan NavigationView
        drawerLayout = findViewById(R.id.drawerLayout)
        navigationView = findViewById(R.id.nav_view)

        // Set up ActionBarDrawerToggle dengan ikon khusus
        toggle = object : ActionBarDrawerToggle(
            this, drawerLayout, toolbar,
            R.string.open, R.string.close
        ) {
            override fun onDrawerOpened(drawerView: android.view.View) {
                super.onDrawerOpened(drawerView)
                supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_close) // Ganti dengan ikon X
            }

            override fun onDrawerClosed(drawerView: android.view.View) {
                super.onDrawerClosed(drawerView)
                supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_menu) // Ganti dengan ikon hamburger
            }
        }

        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        // Menampilkan tombol navigasi di ActionBar
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // Set item selected listener untuk NavigationView
        navigationView.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.nav_home -> Toast.makeText(applicationContext, "Clicked Home", Toast.LENGTH_SHORT).show()
                R.id.nav_message -> Toast.makeText(applicationContext, "Clicked Message", Toast.LENGTH_SHORT).show()
                R.id.nav_sync -> Toast.makeText(applicationContext, "Clicked Sync", Toast.LENGTH_SHORT).show()
                R.id.nav_trash -> Toast.makeText(applicationContext, "Clicked Trash", Toast.LENGTH_SHORT).show()
                R.id.nav_settings -> Toast.makeText(applicationContext, "Clicked Settings", Toast.LENGTH_SHORT).show()
                R.id.nav_login -> Toast.makeText(applicationContext, "Clicked Login", Toast.LENGTH_SHORT).show()
                R.id.nav_share -> Toast.makeText(applicationContext, "Clicked Share", Toast.LENGTH_SHORT).show()
                R.id.rate_us -> Toast.makeText(applicationContext, "Clicked Rate Us", Toast.LENGTH_SHORT).show()
            }
            true
        }
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        // Sinkronisasi toggle state setelah onRestoreInstanceState terjadi.
        toggle.syncState()
        // Pastikan ikon yang benar langsung ditampilkan
        updateDrawerIndicatorIcon()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)) {
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    private fun updateDrawerIndicatorIcon() {
        if (drawerLayout.isDrawerOpen(navigationView)) {
            supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_close) // Ganti dengan ikon X
        } else {
            supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_menu) // Ganti dengan ikon hamburger
        }
    }
}
