package me.aroze.conneccfouw.command

import me.aroze.conneccfouw.board.BoardGenerator
import me.aroze.conneccfouw.lib.isRightless
import me.aroze.conneccfouw.lib.setCommand
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

object TestConnecc : CommandExecutor {

    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {

        if (sender.isRightless("test")) return true

        val player = sender as Player
        val width = args[0].toInt()
        val height = args[1].toInt()

        BoardGenerator(width, height, player.location).generate()

        return true

    }

}