package com.br.funwithaccessibility

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.accessibility.AccessibilityEvent
import android.view.accessibility.AccessibilityManager

fun View.postPerformAccessibilityAction(action: Int, arguments: Bundle? = null) {
    post {
        performAccessibilityAction(action, arguments)
    }
}


fun View.postSendAccessibilityEvent(eventType: Int) {
    post {
        sendAccessibilityEvent(eventType)
    }
}


fun Context.getAccessibilityService() =
    (getSystemService(Context.ACCESSIBILITY_SERVICE) as AccessibilityManager)


fun Context.sendAccessibilityEvent(event: AccessibilityEvent) =
    with((getSystemService(Context.ACCESSIBILITY_SERVICE) as AccessibilityManager)) {
        if(isEnabled) {
            sendAccessibilityEvent(event)
        }
    }