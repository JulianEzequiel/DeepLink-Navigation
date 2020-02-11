package com.example.deeplinknavigation.main.usecase

import com.example.deeplinknavigation.common.MenuOption
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class GetMenuUseCase {

    fun execute(): List<MenuOption> {
        val jsonResponse = "[" +
                "   {" +
                "           text: \"Feature 1\"," +
                "           deeplink: \"dlnav://menu.nav?internal=feature1\"" +
                "   }," +
                "   {" +
                "           text: \"Feature 2\"," +
                "           deeplink: \"dlnav://menu.nav?internal=feature2\"" +
                "   }" +
                "]"

        val type = object : TypeToken<List<MenuOption>>() {}.type
        return Gson().fromJson(jsonResponse, type)
    }

}