package com.example.feature2

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class Feature2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.feature_2_layout)

        findViewById<View>(R.id.button).setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("dlnav://menu.nav?internal=feature1"))
            this.startActivity(intent)
        }
    }

}