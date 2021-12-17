package com.br.intentnavigation

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.pm.ActivityInfo
import android.content.pm.PackageManager
import android.content.pm.ResolveInfo
import android.net.Uri


/*
    https://github.com/chrislucas/sample_nav_modules
*/


fun Context.redirectByDeeplink(deeplink: String, flags: Int, fn: (() -> Unit)? = null) {
    with(this) {
        val resolveInfo = packageManager.resolveActivity(
            Intent.parseUri(deeplink, flags),
            PackageManager.GET_RESOLVED_FILTER or PackageManager.MATCH_DEFAULT_ONLY
        )

        resolveInfo?.let {
            // Intent(this, Class.forName(it.activityInfo.name))
            this.redirect(it.activityInfo.createIntent())
        } ?: fn?.invoke()
    }
}

fun Context.redirectByDeeplink(deeplink: String, fn: (() -> Unit)? = null) = redirectByDeeplink(deeplink, 0, fn)

private fun Context.redirect(intent: Intent) = startActivity(intent)

fun Context.redirectByFirstFromDeepLink(deeplink: String) {
    queryIntentActivities(deeplink)
        ?.takeIf { it.isNotEmpty() }
        ?.let {
            val resolveInfo = it[0]
            resolveInfo.activityInfo.createIntent()
        }
}

private fun ActivityInfo.createIntent(): Intent {
    return with(this@createIntent) {
        val c = ComponentName(this.packageName, this.name)
        with(Intent()) {
            this.apply { this.component = c }
        }
    }
}

fun Context.queryIntentActivities(deeplink: String): List<ResolveInfo>? =
    with(this) {
        packageManager.queryIntentActivities(
            Intent(Intent.ACTION_VIEW, Uri.parse(deeplink)),
            PackageManager.GET_RESOLVED_FILTER or PackageManager.MATCH_DEFAULT_ONLY
        )
    }
