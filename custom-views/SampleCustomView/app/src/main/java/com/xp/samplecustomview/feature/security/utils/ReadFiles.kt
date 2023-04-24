package com.xp.samplecustomview.feature.security.utils

import android.content.Context
import android.content.SharedPreferences
import androidx.security.crypto.EncryptedFile
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKeys
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream


/*
    ref
    https://developer.android.com/topic/security/data
    Work with data more securely

    Work with data more securely across additional Android versions
    https://developer.android.com/topic/security/data-android-versions

 */

/*
    EncryptedFile
    https://developer.android.com/reference/androidx/security/crypto/EncryptedFile
 */
fun <T : Context> T.createEncryptedFile(file: File): EncryptedFile =
    EncryptedFile.Builder(
        file,
        this,
        MasterKeys.getOrCreate(MasterKeys.AES256_GCM_SPEC),
        EncryptedFile.FileEncryptionScheme.AES256_GCM_HKDF_4KB
    ).build()


/*
    https://developer.android.com/topic/security/data-android-versions
 */

fun <T : Context> T.create(filename: String): SharedPreferences =
    EncryptedSharedPreferences.create(
        filename,
        MasterKeys.getOrCreate(MasterKeys.AES256_GCM_SPEC),
        applicationContext,
        EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
        EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM,
    )

val EncryptedFile.outputStream: FileOutputStream
    get() = this.openFileOutput()


val EncryptedFile.inputStream: FileInputStream
    get() = this.openFileInput()