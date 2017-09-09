package net.pl3x.forge.client.proxy;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.event.FMLServerStoppingEvent;
import net.pl3x.forge.client.Pl3xForgeClient;
import net.pl3x.forge.client.recipe.ModRecipes;

public class ClientProxy extends Proxy {
    public void preInit(FMLPreInitializationEvent event) {
        //
    }

    public void init(FMLInitializationEvent event) {
        ModRecipes.init();
    }

    public void postInit(FMLPostInitializationEvent event) {
        //
    }

    public void serverStarting(FMLServerStartingEvent event) {
        //
    }

    public void serverStopping(FMLServerStoppingEvent event) {
        //
    }

    public void registerItemRenderer(Item item, int meta, String id) {
        ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(Pl3xForgeClient.modId + ":" + id, "inventory"));
    }
}