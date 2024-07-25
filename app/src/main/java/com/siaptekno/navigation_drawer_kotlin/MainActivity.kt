package com.siaptekno.navigation_drawer_kotlin

import android.os.Bundle
import android.view.MenuItem
import android.widget.ImageButton
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
    private lateinit var toolbarMenuButton: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inisialisasi Toolbar
        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        // Inisialisasi DrawerLayout dan NavigationView
        drawerLayout = findViewById(R.id.drawerLayout)
        navigationView = findViewById(R.id.nav_view)
        toolbarMenuButton = findViewById(R.id.toolbar_menu_button)

        // Set up ActionBarDrawerToggle
        toggle = object : ActionBarDrawerToggle(
            this, drawerLayout, R.string.open, R.string.close
        ) {
            override fun onDrawerOpened(drawerView: android.view.View) {
                super.onDrawerOpened(drawerView)
                toolbarMenuButton.setImageResource(R.drawable.ic_close) // Ganti dengan ikon X
            }

            override fun onDrawerClosed(drawerView: android.view.View) {
                super.onDrawerClosed(drawerView)
                toolbarMenuButton.setImageResource(R.drawable.ic_menu) // Ganti dengan ikon hamburger
            }
        }

        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        // Menyembunyikan ikon default dan menggunakan ImageButton sebagai tombol drawer
        supportActionBar?.setDisplayHomeAsUpEnabled(false)

        // Menangani klik pada toolbarMenuButton untuk membuka/menutup drawer
        toolbarMenuButton.setOnClickListener {
            if (drawerLayout.isDrawerOpen(navigationView)) {
                drawerLayout.closeDrawer(navigationView)
            } else {
                drawerLayout.openDrawer(navigationView)
            }
        }

        // Set item selected listener untuk NavigationView
        navigationView.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.nav_home -> Toast.makeText(applicationContext, "Clicked Home", Toast.LENGTH_SHORT).show()
                R.id.nav_news -> Toast.makeText(applicationContext, "Clicked News", Toast.LENGTH_SHORT).show()
                R.id.nav_tech -> Toast.makeText(applicationContext, "Clicked Tech", Toast.LENGTH_SHORT).show()
                R.id.nav_share -> Toast.makeText(applicationContext, "Clicked Share", Toast.LENGTH_SHORT).show()
                R.id.nav_rate_us -> Toast.makeText(applicationContext, "Clicked Rate Us", Toast.LENGTH_SHORT).show()

            }
            true
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)) {
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}
