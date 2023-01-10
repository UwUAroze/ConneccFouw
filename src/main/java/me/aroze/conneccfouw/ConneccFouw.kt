package me.aroze.conneccfouw

import me.aroze.conneccfouw.command.TestConnecc
import me.aroze.conneccfouw.lib.setCommand
import org.bukkit.plugin.java.JavaPlugin

class ConneccFouw : JavaPlugin() {

    companion object {
        fun getInstance() : ConneccFouw { return getPlugin(ConneccFouw::class.java) }
    }

    override fun onEnable() {
        TestConnecc.setCommand("testconnecc")
    }

    override fun onDisable() {
        // Plugin shutdown logic
    }
}