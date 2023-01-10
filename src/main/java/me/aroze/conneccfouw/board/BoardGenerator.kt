package me.aroze.conneccfouw.board

import org.bukkit.Location
import org.bukkit.Material
import org.bukkit.util.Vector

class BoardGenerator(val width: Int, val height: Int, val location: Location) {

    val world = location.world!!
    val x = location.x.toInt()
    val y = location.y.toInt()
    val z = location.z.toInt()

    fun generate() {
        generateFrame(x-1, y-1, z, width+2, height+2, Material.WHITE_CONCRETE)
        generateFrame(x-2, y-2, z+1, width+4, height+4, Material.GRAY_CONCRETE)
        fill(x-1, y-1, z+1, width+2, height+2, Material.BLACK_STAINED_GLASS)
        checkerFill(x, y, z-1, width, height, Material.LIGHT_GRAY_CONCRETE, Material.GRAY_CONCRETE)
    }

    private fun generateFrame(startX: Int, startY: Int, startZ: Int, width: Int, length: Int, block: Material) {

        val endX = startX + width
        val endY = startY + length

        for (x in startX .. endX) {
            world.getBlockAt(x, startY, startZ).type = block
            world.getBlockAt(x, endY, startZ).type = block
        }

        for (y in startY .. endY) {
            world.getBlockAt(startX, y, startZ).type = block
            world.getBlockAt(endX, y, startZ).type = block
        }

    }

    private fun fill(startX: Int, startY: Int, startZ: Int, width: Int, length: Int, block: Material) {
        val endX = startX + width
        val endY = startY + length

        for (x in startX .. endX) {
            for (y in startY .. endY) {
                world.getBlockAt(x, y, startZ).type = block
            }
        }
    }

    private fun checkerFill(startX: Int, startY: Int, startZ: Int, width: Int, length: Int, block: Material, alternateBlock: Material) {
        val endX = startX + width
        val endY = startY + length

        for (x in startX .. endX) {
            for (y in startY .. endY) {
                if ((x + y) % 2 == 0) world.getBlockAt(x, y, startZ).type = block
                else world.getBlockAt(x, y, startZ).type = alternateBlock
            }
        }
    }

}