package com.antino.labs_antino


import android.os.Bundle
import android.view.View
import android.view.View.SCROLLBARS_INSIDE_OVERLAY
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.squareup.picasso.Picasso

class Detailed : AppCompatActivity() {
    private lateinit var tvTitle: TextView
    private lateinit var tvSource: TextView
    private lateinit var tvDesc: TextView
    private lateinit var imageView: ImageView
    private lateinit var webView: WebView
    private lateinit var loader: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detailed)
        tvTitle = findViewById(R.id.tvTitle)
        tvSource = findViewById(R.id.tvSource)
        tvDesc = findViewById(R.id.tvDesc)
        imageView = findViewById(R.id.imageView)
        webView = findViewById(R.id.webView)
        loader = findViewById(R.id.webViewLoader)
        loader.visibility = View.VISIBLE
        val intent = intent
        val title = intent.getStringExtra("title")
        val source = intent.getStringExtra("source")
        val desc = intent.getStringExtra("desc")
        val imageUrl = intent.getStringExtra("imageUrl")
        val url = intent.getStringExtra("url")
        tvTitle.text = title
        tvSource.text = source
        tvDesc.text = desc
        Picasso.get().load(imageUrl)
            .error(R.drawable.logo)
            .into(imageView)
        webView.settings.domStorageEnabled = true
        true.also { webView.getSettings().javaScriptEnabled = it }
        webView.settings.loadsImagesAutomatically = true
        webView.scrollBarStyle = SCROLLBARS_INSIDE_OVERLAY
        webView.webViewClient = WebViewClient()
        webView.loadUrl(url!!)
        if (webView.isShown) {
            loader.visibility = View.INVISIBLE
        }
    }
}