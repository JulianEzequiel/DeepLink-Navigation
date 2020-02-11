package com.example.deeplinknavigation.main.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.deeplinknavigation.R
import com.example.deeplinknavigation.common.MenuOption

interface MenuSelectionListener {

    fun onMenuOptionSelected(deeplink: String)

}

class MenuAdapter(
    private val options: List<MenuOption>,
    private val listener: MenuSelectionListener
) : RecyclerView.Adapter<MenuItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.menu_option_layout, parent, false)
        return MenuItemViewHolder(view)
    }

    override fun getItemCount(): Int = options.size

    override fun onBindViewHolder(holder: MenuItemViewHolder, position: Int) {
        val option = this.options.get(position)

        holder.optionNameText.text = option.text

        holder.itemView.setOnClickListener {
            listener.onMenuOptionSelected(option.deeplink)
        }
    }

}

class MenuItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    val optionNameText : TextView

    init {
        this.optionNameText = view.findViewById(R.id.option_title_text)
    }

}