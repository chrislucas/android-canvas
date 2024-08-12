package com.br.funwithaccessibility.extensions

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.accessibility.AccessibilityEvent
import android.view.accessibility.AccessibilityManager

fun View.postFireAccessibilityAction(action: Int, arguments: Bundle? = null) {
    post {
        performAccessibilityAction(action, arguments)
    }
}

fun View.postDelayedFireAccessibilityAction(action: Int, delay: Long = 1L, arguments: Bundle? = null) {
    postDelayed(
        {
            performAccessibilityAction(action, arguments)
        }, delay
    )
}

fun View.postSendAccessibilityEvent(eventType: Int) {
    post {
        sendAccessibilityEvent(eventType)
    }
}

fun View.postDelayedSendAccessibilityEvent(eventType: Int, delay: Long = 1L) {
    postDelayed({
        sendAccessibilityEvent(eventType)
    }, delay)
}

fun Context.getAccessibilityService() =
    (getSystemService(Context.ACCESSIBILITY_SERVICE) as AccessibilityManager)

fun Context.fromAccessibilityManagerFireEvent(event: AccessibilityEvent) =
    with((getSystemService(Context.ACCESSIBILITY_SERVICE) as AccessibilityManager)) {
        if (isEnabled) {
            sendAccessibilityEvent(event)
        }
    }