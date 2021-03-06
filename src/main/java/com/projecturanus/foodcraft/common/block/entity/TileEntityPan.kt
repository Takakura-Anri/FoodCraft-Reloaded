package com.projecturanus.foodcraft.common.block.entity

import com.projecturanus.foodcraft.common.config.FcConfig
import com.projecturanus.foodcraft.common.heat.FuelHeatHandler
import com.projecturanus.foodcraft.common.init.FCRItems
import com.projecturanus.foodcraft.common.recipe.PAN_RECIPES
import com.projecturanus.foodcraft.common.recipe.PanRecipe
import com.projecturanus.foodcraft.common.util.get
import com.projecturanus.foodcraft.common.util.shrink
import net.minecraft.item.ItemStack
import org.cyclops.commoncapabilities.api.capability.temperature.ITemperature

class TileEntityPan : TileEntityHeatRecipeMachine<PanRecipe>(PAN_RECIPES, 0..0, 1..1, 3) {
    override var minProgress = recipe?.minTime ?: 10000

    var waitingExtract = false

    init {
        inventory.contentChangedListener += {
            if (it == 1 && inventory[1].isEmpty) {
                reset()
            }
        }
    }

    override fun update() {
        // Don't run tick on client
        if (world.isRemote) return

        beforeProgress()

        if (waitingExtract && progress > recipe?.maxTime ?: Int.MAX_VALUE) { // Overcooked
            inventory.shrink(1)
            inventory.insertItem(2, ItemStack(FCRItems.OVERCOOKED_FOOD), false)
            reset()
        }

        if (recipe != null) {
            // Finish
            if (canFinish()) {
                consumeInput()
                working = false
                val stack = recipe?.getRecipeOutput()?.copy() ?: ItemStack.EMPTY
                inventory.insertItem(1, stack, false)
                waitingExtract = true
                markDirty()
            } else {
                if (canProgress())
                    progress++
                working = true
            }
        } else if (waitingExtract) {
            progress++
        } else if (!waitingExtract && progress > 0) {
            progress = 0
            working = false
        }
    }

    override fun reset() {
        waitingExtract = false
        progress = 0
        markDirty()
        recipe = findRecipe()
    }

    override fun beforeProgress() {
        heatHandler.update(0.0)
    }

    override fun canProgress(): Boolean = heatHandler.temperature > ITemperature.ZERO_CELCIUS + FcConfig.machineConfig.panHeat

    override fun canFinish(): Boolean = progress > recipe?.minTime ?: Int.MAX_VALUE && progress < recipe?.maxTime ?: -1 && !waitingExtract

    override fun createFuelHandler(): FuelHeatHandler {
        val heatHandler = FuelHeatHandler()
        heatHandler.radiation = FcConfig.machineConfig.panRadiation
        heatHandler.heatPower = FcConfig.machineConfig.panPower
        heatHandler.setMaxHeat(ITemperature.ZERO_CELCIUS + FcConfig.machineConfig.panHeat + 100)
        return heatHandler
    }
}
