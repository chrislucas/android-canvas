package com.xp.samplecustomview.feature.webview.clients

import android.webkit.WebView
import android.webkit.WebViewClient

/*
    https://coderwall.com/p/pg1l2g/block-all-links-inside-a-webview
 */
class WebViewClientBlockAllLinks : WebViewClient() {
    override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
        /*
            retornar true vai impedir de carregar o link
         */
        return true
    }
}


class WebViewClientCheckAllowedDomain(
    private val templateAllowedDomainWebView:
    TemplateAllowedDomainWebView
) : WebViewClient() {
    override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
        /*
            Se passar pela validacao carrega o link
         */
        return url?.let { templateAllowedDomainWebView.check(it) } ?: false
    }
}


abstract class TemplateAllowedDomainWebView {
    abstract fun checkUrl(url: String): Boolean

    fun check(url: String) = checkUrl(url)
}

class AllowedDomainWebView(private val domains: List<String>) : TemplateAllowedDomainWebView() {

    override fun checkUrl(url: String): Boolean = domains.contains(url)
}