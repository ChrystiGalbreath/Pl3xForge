package net.pl3x.forge.core.recipe;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.pl3x.forge.core.block.ModBlocks;
import net.pl3x.forge.core.item.ModItems;

public class ModRecipes {
    public static void init() {
        // Ore Dict
        ModBlocks.blockRuby.initOreDict();
        ModBlocks.oreRuby.initOreDict();
        ModItems.ruby.initOreDict();

        // Smelting
        GameRegistry.addSmelting(ModBlocks.oreRuby, new ItemStack(ModItems.ruby), 0.7f);
    }
}
