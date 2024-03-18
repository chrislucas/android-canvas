package com.br.experience.features.utils.roomdb

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase

inline fun <reified T : RoomDatabase> Context.createRoomDatabaseWithCallback(name: String, callback: RoomDatabase.Callback): T =
    Room.databaseBuilder(this, T::class.java, name)
        .addCallback(callback)
        .build()