package com.br.funwithaccessibility

import android.accessibilityservice.AccessibilityService
import android.util.Log
import android.view.accessibility.AccessibilityEvent

/**
 * AccessibilityService
 * https://developer.android.com/reference/android/accessibilityservice/AccessibilityService
 *
 * Create your own accessibility service
 * https://developer.android.com/guide/topics/ui/accessibility/service
 */
class CustomAccessibilityService: AccessibilityService() {

    override fun onAccessibilityEvent(event: AccessibilityEvent?) {
        event?.let {
            when(it.eventType) {
                AccessibilityEvent.TYPE_VIEW_FOCUSED -> {

                }
                else -> {

                }
            }
        }

    }

    override fun onInterrupt() {
        if (Log.isLoggable("CUSTOM_ACCESSIBILITY_SV", Log.INFO)) {
            Log.i("CUSTOM_ACCESSIBILITY_SV", "onInterrupt")
        }
    }
}