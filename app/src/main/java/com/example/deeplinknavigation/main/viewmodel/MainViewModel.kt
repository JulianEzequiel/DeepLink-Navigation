package com.example.deeplinknavigation.main.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.deeplinknavigation.common.MenuOption
import com.example.deeplinknavigation.main.usecase.GetMenuUseCase

class MainViewModel : ViewModel() {

    private val _menuOptions = MutableLiveData<List<MenuOption>>()
    val menuOptions: LiveData<List<MenuOption>> get() = _menuOptions

    init {
        this.getMenuOptions()
    }

    private fun getMenuOptions() {
        this._menuOptions.value = GetMenuUseCase().execute()
    }

}