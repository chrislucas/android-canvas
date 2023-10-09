package com.br.openactivity

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.pm.ActivityInfo
import android.content.pm.PackageManager
import android.content.pm.PackageManager.ResolveInfoFlags
import android.os.Build
import android.widget.Toast

private fun showErrorMessage(context: Context, deeplink: String) {
    Toast.makeText(
        context,
        context.getString(R.string.msg_error_try_open_activity_by_deeplink, deeplink),
        Toast.LENGTH_LONG
    ).show()
}

fun Context.startActivityByDeeplink(
    deeplink: String,
    flags: Int? = null,
    fn: (() -> Unit) = { showErrorMessage(this, deeplink) }
) {
    with(this) {
        val defaultFlags =
            Intent.FLAG_ACTIVITY_CLEAR_TASK or
                    Intent.FLAG_ACTIVITY_NEW_TASK or
                    Intent.URI_ALLOW_UNSAFE or
                    Intent.URI_ANDROID_APP_SCHEME or
                    Intent.URI_INTENT_SCHEME

        val intent = Intent.parseUri(deeplink, flags ?: defaultFlags)

        /**
         * Pesquisar sobre essa classe
         * https://developer.android.com/reference/android/content/pm/PackageManager.ResolveInfoFlags
         */

        val resolveInfo = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            packageManager.resolveActivity(
                intent,
                ResolveInfoFlags.of(
                    PackageManager.GET_RESOLVED_FILTER.toLong() or PackageManager.MATCH_DEFAULT_ONLY.toLong()
                )
            )
        } else {
            packageManager.resolveActivity(
                intent,
                PackageManager.GET_RESOLVED_FILTER or PackageManager.MATCH_DEFAULT_ONLY
            )
        }



        resolveInfo?.let {
            this.redirect(it.activityInfo.createIntent())
        } ?: fn.invoke()
    }
}

private fun Context.redirect(intent: Intent) = startActivity(intent)

private fun ActivityInfo.createIntent(): Intent {
    return with(this@createIntent) {
        val c = ComponentName(this.packageName, this.name)
        with(Intent()) {
            this.apply { this.component = c }
        }
    }
}