package com.example.deeplinknavigation.main.ui

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.deeplinknavigation.R
import com.example.deeplinknavigation.main.ui.adapter.MenuAdapter
import com.example.deeplinknavigation.main.ui.adapter.MenuSelectionListener
import com.example.deeplinknavigation.main.viewmodel.MainViewModel

class MainActivity : AppCompatActivity(),
    MenuSelectionListener {

    lateinit var recyclerView : RecyclerView

    val mainViewModel : MainViewModel by lazy {
        ViewModelProvider.NewInstanceFactory().create(MainViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.configureViews()

        this.bindObservers()
    }

    override fun onMenuOptionSelected(deeplink: String) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(deeplink))
        this.startActivity(intent)
    }

    private fun configureViews() {
        this.recyclerView = this.findViewById(R.id.menu_list)
        this.recyclerView.layoutManager = LinearLayoutManager(this)
    }

    private fun bindObservers() {
        this.mainViewModel.menuOptions.observe(this, Observer {
            recyclerView.adapter = MenuAdapter(it, this)
        })
    }
}
