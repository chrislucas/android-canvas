package com.br.experience.features.tutorials.medium.db.fromroomtodelight

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.br.experience.radaranimation.databinding.ActivityFromRoomToSqlDelightBinding

/**
 * https://raed-o-ghazal.medium.com/migrate-your-production-app-from-room-db-to-sqldelight-c99127bbdc8
 */
class FromRoomToSqlDelightActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFromRoomToSqlDelightBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityFromRoomToSqlDelightBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}