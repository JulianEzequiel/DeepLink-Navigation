package com.example.deeplinknavigation.deeplink

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class DeepLinkProcessor : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val data: Uri? = intent?.data

        data?.getQueryParameter("internal")?.let {
            val newUri = "dlnav://$it"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(newUri))
            startActivity(intent)
            finish()
        }
    }

}